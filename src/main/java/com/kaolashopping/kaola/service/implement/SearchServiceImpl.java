package com.kaolashopping.kaola.service.implement;

import com.alibaba.fastjson.JSON;
import com.kaolashopping.kaola.bean.Car;
import com.kaolashopping.kaola.bean.EvaluateIdNode;
import com.kaolashopping.kaola.bean.HotCar;
import com.kaolashopping.kaola.bean.User;
import com.kaolashopping.kaola.mapper.CarMapper;
import com.kaolashopping.kaola.mapper.SearchMapper;
import com.kaolashopping.kaola.service.ProductsService;
import com.kaolashopping.kaola.service.SearchService;
import com.kaolashopping.kaola.utils.CommonUtils;
import com.kaolashopping.kaola.utils.LocalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@EnableAsync
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchMapper searchMapper;

    @Autowired
    private ProductsService productsService;

    @Autowired
    private CarMapper carMapper;

    /**
     * 登录用户条件搜索
     *
     * @param searchCondition
     * @return
     */
    @Override
    public List<Car> getSimCars(Map<String, String> searchCondition) {
        int minPrice = Integer.parseInt(searchCondition.remove("minPrice"));
        int maxPrice = Integer.parseInt(searchCondition.remove("maxPrice"));
        int type = Integer.parseInt(searchCondition.remove("type"));
        String carType = CommonUtils.carType.get(type);

        Map<Integer, Car> allCars = productsService.getAllCars();
        HashMap<Integer, Car> map = new HashMap<>(allCars.size());
        Map<String, Float> tarMap = new HashMap<>(searchCondition.size());
        for (String s : searchCondition.keySet()) {
            tarMap.put(s, Float.parseFloat(searchCondition.get(s)));
        }

        Comparator<EvaluateIdNode> comparator = (o1, o2) -> {
            if (o1.getSimRatio() == o2.getSimRatio()) {
                return 0;
            }
            return o1.getSimRatio() > o2.getSimRatio() ? -1 : 1;
        };

        PriorityQueue<EvaluateIdNode> simTypeCars = new PriorityQueue<>(comparator);
        PriorityQueue<EvaluateIdNode> difSimTypeCars = new PriorityQueue<>(comparator);

        for (Car car : map.values()) {
            BeanMap beanMap = BeanMap.create(car);
            Map<String, Float> carMap = new HashMap<>();
            for (Object o : beanMap.keySet()) {
                carMap.put(String.valueOf(o), (Float) beanMap.get(o));
            }
            float pearsonCoefficient = CommonUtils.getPearsonCoefficient(tarMap, carMap);
            if (carType != null && carType.equals(car.getType())) {
                simTypeCars.add(new EvaluateIdNode(car.getId(), pearsonCoefficient));
            } else {
                difSimTypeCars.add(new EvaluateIdNode(car.getId(), pearsonCoefficient));
            }
        }

        // 过滤掉价格不合适的汽车
        PriorityQueue<EvaluateIdNode> priceUnfitQueueForSim = new PriorityQueue<>(comparator);
        PriorityQueue<EvaluateIdNode> priceUnfitQueueForDiff = new PriorityQueue<>(comparator);
        for (EvaluateIdNode simTypeCar : simTypeCars) {
            if (map.get(simTypeCar.getId()).getMinPrice() > maxPrice ||
                    map.get(simTypeCar.getId()).getMaxPrice() < minPrice) {
                priceUnfitQueueForSim.add(simTypeCar);
                simTypeCars.remove(simTypeCar);
            }
        }
        for (EvaluateIdNode simTypeCar : difSimTypeCars) {
            if (map.get(simTypeCar.getId()).getMinPrice() > maxPrice ||
                    map.get(simTypeCar.getId()).getMaxPrice() < minPrice) {
                priceUnfitQueueForDiff.add(simTypeCar);
                difSimTypeCars.remove(simTypeCar);
            }
        }
        // 最多只保留20辆车
        PriorityQueue<EvaluateIdNode> resSimTypeCars = removeExtraCar(simTypeCars, comparator);
        PriorityQueue<EvaluateIdNode> resDiffTypeCars = removeExtraCar(simTypeCars, comparator);

        // 合并结果集
        List<Car> res = new ArrayList<>(resSimTypeCars.size() + resDiffTypeCars.size() +
                priceUnfitQueueForSim.size() + priceUnfitQueueForDiff.size());
        List<Car> updateData = new ArrayList<>(resSimTypeCars.size() + resDiffTypeCars.size());
        for (EvaluateIdNode evaluateIdNode : resSimTypeCars) {
            res.add(map.get(evaluateIdNode.getId()));
            updateData.add(map.get(evaluateIdNode.getId()));
        }
        for (EvaluateIdNode evaluateIdNode : resDiffTypeCars) {
            res.add(map.get(evaluateIdNode.getId()));
        }
        for (EvaluateIdNode evaluateIdNode : priceUnfitQueueForSim) {
            res.add(map.get(evaluateIdNode.getId()));
        }
        for (EvaluateIdNode evaluateIdNode : priceUnfitQueueForDiff) {
            res.add(map.get(evaluateIdNode.getId()));
        }

        // 异步更新用户个性化推荐
        updateUserRecommand(updateData, LocalUser.getUser());

        return res;
    }

    /**
     * 更新用户的个性化推荐
     *
     * @param cars
     */
    @Async
    public void updateUserRecommand(List<Car> cars, User user) {
        Map<Integer, Integer> idCount = new HashMap<>();
        Map<String, Integer> brandCount = new HashMap<>();
        Map<Integer, String> tmpIdAndBrand = new HashMap<>();
        for (Car car : cars) {
            String simIds = car.getEvaluate();
            String[] ids = simIds.split(" ");
            for (String id : ids) {
                int carId = Integer.parseInt(id);
                idCount.put(carId, idCount.containsKey(carId) ? idCount.get(carId) + 1 : 1);
                String brand;
                if (tmpIdAndBrand.containsKey(car.getParentId())) {
                    brand = tmpIdAndBrand.get(car.getParentId());
                } else {
                    Car parentCar = carMapper.getCarById(car.getParentId());
                    brand = parentCar.getBrand();
                    tmpIdAndBrand.put(parentCar.getId(), brand);
                }
                brandCount.put(brand, brandCount.containsKey(brand) ? brandCount.get(brand) + 1 : 1);
            }
        }
        HotCar hotCar = searchMapper.getHotCarByUser(user.getId());
        if (hotCar == null) {
            hotCar = new HotCar(user.getId(), JSON.toJSONString(idCount), JSON.toJSONString(brandCount));
        } else {
            String carContent = hotCar.getCarContent();
            String brandContent = hotCar.getBrandContent();
            if (carContent != null) {

            }
        }
    }

    /**
     * 删除堆中多的车辆信息，只保留前20条
     *
     * @param queue
     * @param comparator
     * @return
     */
    private PriorityQueue<EvaluateIdNode> removeExtraCar(PriorityQueue<EvaluateIdNode> queue, Comparator<EvaluateIdNode> comparator) {
        PriorityQueue<EvaluateIdNode> resQueue = new PriorityQueue<>(comparator);
        for (int i = 0; i < 20; i++) {
            resQueue.add(queue.poll());
        }
        return resQueue;
    }

    /**
     * 游客用户条件搜索
     *
     * @param searchCondition
     * @param touristKey
     * @return
     */
    @Override
    public List<Car> getSimCars(Map<String, String> searchCondition, String touristKey) {
        return null;
    }
}
