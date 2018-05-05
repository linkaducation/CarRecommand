package com.kaolashopping.kaola.service.implement;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.kaolashopping.kaola.bean.Car;
import com.kaolashopping.kaola.bean.CarModel;
import com.kaolashopping.kaola.bean.EvaluateIdNode;
import com.kaolashopping.kaola.bean.OveragePremiumRateOfCarUsingAge;
import com.kaolashopping.kaola.mapper.CarMapper;
import com.kaolashopping.kaola.mapper.CarModelMapper;
import com.kaolashopping.kaola.redis.RedisUtils;
import com.kaolashopping.kaola.service.CarModelService;
import com.kaolashopping.kaola.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author ming.zhong
 * @date 2018/3/24 下午9:56
 */
@Service
public class CarModelServiceImpl implements CarModelService {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private CarModelMapper carModelMapper;

    @Autowired
    private CarMapper carMapper;

    private static String CARMODELKEY = "CAR_MODEL_INFO_KEY";

    /**
     * 初始化所有car的保值率
     *
     * @return
     */
    @Override
    public List<OveragePremiumRateOfCarUsingAge> initCarModel() {
        String carInfo = redisUtils.get(CARMODELKEY);
        List<OveragePremiumRateOfCarUsingAge> ret = new ArrayList<>();
        if (carInfo == null) {
            List<String> distinctCarBrand = carModelMapper.getDistinctCarModel();
            for (String brand : distinctCarBrand) {
                if (!brand.endsWith("年") && !brand.matches("\\d{4}")) {
                    for (int i = 0; i <= 40; i++) {
                        List<CarModel> carModels = carModelMapper.getCarByBrand(brand, i);
                        int totalCars = carModels.size();
                        double totalPremiunRate = 0.0;
                        if (carModels.isEmpty()) {
                            break;
                        }
                        for (CarModel carModel : carModels) {
                            if (carModel.getPremiumRate() > 0.02) {
                                totalPremiunRate += carModel.getPremiumRate();
                            } else {
                                totalCars -= 1;
                            }
                        }
                        OveragePremiumRateOfCarUsingAge oprca = new OveragePremiumRateOfCarUsingAge();
                        oprca.setBrand(brand);
                        oprca.setCarAge(i);
                        oprca.setPremiumRate((float) (totalPremiunRate / totalCars));
                        oprca.setSampleCount(totalCars);
                        carModelMapper.removeOldModel(brand, i);
                        int res = carModelMapper.saveModel(oprca);
                        if (res > 0) {
                            ret.add(oprca);
                            System.out.println("成功插入一条carModel:" + brand);
                        }
                    }
                }
            }
        }
        return ret;
    }

    /**
     * 获取某个品牌的保值率
     *
     * @param car
     * @return
     */
    @Override
    public List<Float> getPremiumRateByBrand(Car car) {
        String brand = car.getBrand();
        if (brand.contains("(")) {
            int start = brand.indexOf("(");
            brand = brand.substring(0, start);
        }
        List<OveragePremiumRateOfCarUsingAge> res = carModelMapper.getDataByBrand(brand);
        Car parentCar = carMapper.getCarById(car.getParentId());
        if (parentCar != null) {
            brand = parentCar.getBrand() + car.getBrand();
        } else {
            brand = car.getBrand();
        }
        List<OveragePremiumRateOfCarUsingAge> res2 = carModelMapper.getDataByBrand(brand);
        return combineResults(res, res2);
    }

    /**
     * 求出所有car的皮尔逊系数
     *
     * @return
     */
    @Override
    public boolean initPear() {

        Map<Integer, Car> map = CommonUtils.allCars;
        for (Car car : map.values()) {
            PriorityQueue<EvaluateIdNode> priorityQueue = new PriorityQueue<>((o1, o2) -> {
                if (o1.getSimRatio() == o2.getSimRatio()) {
                    return 0;
                }
                return o1.getSimRatio() > o2.getSimRatio() ? -1 : 1;
            });
            for (Car car1 : map.values()) {
                if (car == car1) {
                    continue;
                }
                String evaluate1 = car.getEvaluate();
                String evaluate2 = car1.getEvaluate();
                HashMap<String, Float> map1 = JSON.parseObject(evaluate1, new TypeReference<HashMap<String, Float>>() {
                });
                HashMap<String, Float> map2 = JSON.parseObject(evaluate2, new TypeReference<HashMap<String, Float>>() {
                });
                float pearsonCoefficient = CommonUtils.getPearsonCoefficient(map1, map2);
                if (car1.getId() > 0 && pearsonCoefficient != 0) {
                    priorityQueue.add(new EvaluateIdNode(car1.getId(), pearsonCoefficient));
                }
            }
            initSimCar(map, priorityQueue, car.getId());
        }
        return true;
    }

    /**
     * 求皮尔逊系数
     *
     * @param carModels
     * @param priorityQueue
     * @param carId
     */
    private void initSimCar(Map<Integer, Car> carModels, PriorityQueue<EvaluateIdNode> priorityQueue, int carId) {
        Car originCar = carModels.get(carId);
        int otherCount = 0;
        int simCount = 0;
        StringBuilder simTypeCars = new StringBuilder();
        StringBuilder otherCars = new StringBuilder();
        while (!priorityQueue.isEmpty() && (simCount < 10 || otherCount < 10)) {
            EvaluateIdNode node = priorityQueue.poll();
            if (node == null || node.getId() == -1) {
                continue;
            }
            Car car = carModels.get(node.getId());
            if (car != null && !car.getBrand().equals(originCar.getBrand())) {
                if (car.getType().equals(originCar.getType()) && simCount < 10) {
                    simTypeCars.append(String.valueOf(car.getId())).append(" ");
                    simCount++;
                } else if (CommonUtils.carModelConfig.get(originCar.getType()).contains(car.getType()) && otherCount < 10) {
                    otherCars.append(String.valueOf(car.getId())).append(" ");
                    otherCount++;
                }
            }
        }
        if (simTypeCars.length() > 0) {
            simTypeCars.deleteCharAt(simTypeCars.length() - 1);
        }
        if (otherCars.length() > 0) {
            otherCars.deleteCharAt(otherCars.length() - 1);
        }
        carMapper.updateSimCarById(carId, simTypeCars.toString(), otherCars.toString());
    }

    /**
     * 合并上面两种方式求出来的保值率
     *
     * @param res1
     * @param res2
     * @return
     */
    private List<Float> combineResults(List<OveragePremiumRateOfCarUsingAge> res1,
                                       List<OveragePremiumRateOfCarUsingAge> res2) {
        int minLength = res1.size() < res2.size() ? res1.size() : res2.size();
        List<Float> res = new ArrayList<>();
        int i = 0, j = 0;
        for (; i < minLength && j < minLength; ) {
            if (res1.get(i).getCarAge() % 2 == 0) {
                i++;
                continue;
            }
            if (res2.get(j).getCarAge() % 2 == 0) {
                j++;
                continue;
            }
            OveragePremiumRateOfCarUsingAge ins1 = res1.get(i);
            OveragePremiumRateOfCarUsingAge ins2 = res2.get(j);
            if (ins1.getCarAge() == ins2.getCarAge()) {
                float premiunRate = (float) ((ins1.getPremiumRate() * ins1.getSampleCount() + ins2.getPremiumRate()
                        * ins2.getSampleCount()) / (ins1.getSampleCount() + ins2.getSampleCount() + 0.0));
                res.add((float) (Math.round(premiunRate * 100)));
                i++;
                j++;
            } else if (ins1.getCarAge() < ins2.getCarAge()) {
                i++;
                res.add((float) Math.round(ins1.getPremiumRate() * 100));
            } else {
                j++;
                res.add((float) Math.round(ins2.getPremiumRate() * 100));
            }
        }
        if (i < res1.size()) {
            for (; i < res1.size(); i++) {
                if (res1.get(i).getCarAge() % 2 == 1) {
                    res.add((float) Math.round(res1.get(i).getPremiumRate() * 100));
                }
            }
        }
        if (j < res2.size()) {
            for (; j < res2.size(); j++) {
                if (res2.get(j).getSampleCount() % 2 == 1) {
                    res.add((float) Math.round(res2.get(j).getPremiumRate() * 100));
                }
            }
        }
        if (res.isEmpty()) {
            if (!res1.isEmpty()) {
                res.add((float) Math.round(res1.get(0).getPremiumRate() * 100));
            }
        }
        if (res.isEmpty()) {
            if (!res2.isEmpty()) {
                res.add((float) Math.round(res2.get(0).getPremiumRate() * 100));
            }
        }
        return res;
    }

}
