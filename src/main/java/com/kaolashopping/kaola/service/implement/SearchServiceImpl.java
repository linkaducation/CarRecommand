package com.kaolashopping.kaola.service.implement;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.kaolashopping.kaola.bean.Car;
import com.kaolashopping.kaola.bean.EvaluateIdNode;
import com.kaolashopping.kaola.bean.HotCar;
import com.kaolashopping.kaola.bean.TouristUser;
import com.kaolashopping.kaola.mapper.CarMapper;
import com.kaolashopping.kaola.mapper.PersonallizMapper;
import com.kaolashopping.kaola.mapper.SearchMapper;
import com.kaolashopping.kaola.service.ProductsService;
import com.kaolashopping.kaola.service.SearchService;
import com.kaolashopping.kaola.utils.CommonUtils;
import com.kaolashopping.kaola.utils.LocalUser;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private PersonallizMapper personallizMapper;

    /**
     * 登录用户条件搜索
     *
     * @param searchCondition
     * @return
     */
    @Override
    public List<Car> getSimCars(Map<String, String> searchCondition) {

        // 异步更新用户个性化推荐
        Map<String, List<Car>> resMap = doGetSimCars(searchCondition);
        updateUserRecommand(resMap.get("updateData"), LocalUser.getUser().getId());
        return resMap.get("res");
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
        Map<String, List<Car>> resMap = doGetSimCars(searchCondition);
        TouristUser touristUser = personallizMapper.getTouristUserByTouristKey(touristKey);
        if (touristUser == null) {
            personallizMapper.addTouristUser(new TouristUser(touristKey));
            touristUser = personallizMapper.getTouristUserByTouristKey(touristKey);
        }
        updateUserRecommand(resMap.get("updateData"), touristUser.getId());
        return resMap.get("res");
    }

    /**
     * 执行查询相识car操作
     *
     * @param searchCondition
     * @return
     */
    private Map<String, List<Car>> doGetSimCars(Map<String, String> searchCondition) {
        int minPrice = Integer.parseInt(searchCondition.remove("minPrice"));
        int maxPrice = Integer.parseInt(searchCondition.remove("maxPrice"));
        int type = Integer.parseInt(searchCondition.remove("type"));
        String carType = CommonUtils.carType.get(type);

        Map<Integer, Car> allCars = productsService.getAllCars();
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

        for (Car car : allCars.values()) {
            Map<String, Float> carMap = JSON.parseObject(car.getEvaluate(), new TypeReference<Map<String, Float>>() {
            });
            float pearsonCoefficient = CommonUtils.getPearsonCoefficient(tarMap, carMap);
            if (carType != null && carType.equals(car.getType())) {
                simTypeCars.add(new EvaluateIdNode(car.getId(), pearsonCoefficient));
            } else {
                difSimTypeCars.add(new EvaluateIdNode(car.getId(), pearsonCoefficient));
            }
        }

        // 过滤掉价格不合适的汽车
        PriorityQueue<EvaluateIdNode> priceUnfitQueueForSim = getQueue(minPrice, maxPrice, simTypeCars,
                allCars, comparator);
        PriorityQueue<EvaluateIdNode> priceUnfitQueueForDiff = getQueue(minPrice, maxPrice, difSimTypeCars,
                allCars, comparator);

        // 最多只保留20辆车
        PriorityQueue<EvaluateIdNode> resSimTypeCars = removeExtraCar(priceUnfitQueueForSim, comparator);
        PriorityQueue<EvaluateIdNode> resDiffTypeCars = removeExtraCar(priceUnfitQueueForDiff, comparator);

        // 合并结果集
        List<Car> res = new ArrayList<>(resSimTypeCars.size() + resDiffTypeCars.size() +
                priceUnfitQueueForSim.size() + priceUnfitQueueForDiff.size());
        List<Car> updateData = new ArrayList<>(resSimTypeCars.size() + resDiffTypeCars.size());
        for (EvaluateIdNode evaluateIdNode : resSimTypeCars) {
            res.add(allCars.get(evaluateIdNode.getId()));
            updateData.add(allCars.get(evaluateIdNode.getId()));
        }
        String type1 = searchCondition.get("type");
        for (EvaluateIdNode evaluateIdNode : resDiffTypeCars) {
            if (res.size() >= 50 || "11".equals(type1) || "12".equals(type1) || "13".equals(type1)) {
                break;
            }
            res.add(allCars.get(evaluateIdNode.getId()));
        }
        for (EvaluateIdNode evaluateIdNode : priceUnfitQueueForSim) {
            if (res.size() >= 50 || "11".equals(type1) || "12".equals(type1) || "13".equals(type1)) {
                break;
            }
            res.add(allCars.get(evaluateIdNode.getId()));
        }
        for (EvaluateIdNode evaluateIdNode : priceUnfitQueueForDiff) {
            if (res.size() >= 50 || "11".equals(type1) || "12".equals(type1) || "13".equals(type1)) {
                break;
            }
            res.add(allCars.get(evaluateIdNode.getId()));
        }
        Map<String, List<Car>> result = new HashMap<>(2);
        result.put("res", res);
        result.put("updateData", updateData);
        return result;
    }

    /**
     * 删除evaluateIdNodes中价格不合适的车辆
     *
     * @param minPrice:        最低价格
     * @param maxPrice:        最高价格
     * @param evaluateIdNodes: 要进行筛选的队列
     * @param map:             保存carId和car的hash表
     * @param comparator:      大顶堆的comparator
     * @return
     */
    private PriorityQueue<EvaluateIdNode> getQueue(int minPrice, int maxPrice,
                                                   PriorityQueue<EvaluateIdNode> evaluateIdNodes,
                                                   Map<Integer, Car> map,
                                                   Comparator<EvaluateIdNode> comparator) {
        PriorityQueue<EvaluateIdNode> queue = new PriorityQueue<>(comparator);
        if (evaluateIdNodes == null || evaluateIdNodes.isEmpty()) {
            return queue;
        }
        for (EvaluateIdNode diffTypeCar : evaluateIdNodes) {
            if (minPrice != 0 && map.get(diffTypeCar.getId()).getMaxPrice() < minPrice) {
                continue;
            }
            if (maxPrice != 0 && map.get(diffTypeCar.getId()).getMinPrice() > maxPrice) {
                continue;
            }
            queue.add(diffTypeCar);
        }
        for (EvaluateIdNode node : queue) {
            evaluateIdNodes.remove(node);
        }
        return queue;
    }

    /**
     * 更新用户的个性化推荐
     *
     * @param cars
     */
    @Async
    @Override
    public void updateUserRecommand(List<Car> cars, int userId) {
        Map<Integer, Integer> idCount = new HashMap<>();
        Map<String, Integer> brandCount = new HashMap<>();
        Map<Integer, String> tmpIdAndBrand = new HashMap<>();
        for (Car car : cars) {
            String simIds = car.getSimIds();
            if (simIds == null || simIds.trim().equals("")) {
                continue;
            }
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
        if (idCount.isEmpty()) {
            return;
        }
        HotCar hotCar = searchMapper.getHotCarByUser(userId);
        if (hotCar == null) {
            hotCar = new HotCar(userId, JSON.toJSONString(idCount), JSON.toJSONString(brandCount));
            searchMapper.insertHotCar(hotCar);
        } else {
            //合并结果集， 提取出频率最高的
            String carContent = hotCar.getCarContent();
            String brandContent = hotCar.getBrandContent();
            if (carContent != null) {
                Map<Integer, Integer> carCount = JSON.parseObject(carContent, new TypeReference<Map<Integer, Integer>>() {
                });
                for (Integer carId : idCount.keySet()) {
                    int count;
                    if (carCount.containsKey(carId)) {
                        count = carCount.get(carId) + idCount.get(carId);
                    } else {
                        count = idCount.get(carId);
                    }
                    carCount.put(carId, count);
                }
                List<Map.Entry<Integer, Integer>> list = new ArrayList<>(carCount.entrySet());
                list.sort(Comparator.comparing(Map.Entry::getValue));
                Collections.reverse(list);
                int i = 0;
                Map<Integer, Integer> res = new LinkedHashMap<>(list.size());
                for (Map.Entry<Integer, Integer> entry : list) {
                    i++;
                    res.put(entry.getKey(), entry.getValue());
                    if (i >= 20) {
                        break;
                    }
                }
                hotCar.setCarContent(JSON.toJSONString(res));
            } else {
                hotCar.setCarContent(JSON.toJSONString(idCount));
            }
            if (brandContent != null) {
                Map<String, Integer> brandMap = JSON.parseObject(brandContent, new TypeReference<Map<String, Integer>>() {
                });
                for (String carId : brandCount.keySet()) {
                    int count;
                    if (brandMap.containsKey(carId)) {
                        count = brandMap.get(carId) + brandCount.get(carId);
                    } else {
                        count = brandCount.get(carId);
                    }
                    brandMap.put(carId, count);
                }
                List<Map.Entry<String, Integer>> list = new ArrayList<>(brandMap.entrySet());
                list.sort(Comparator.comparing(Map.Entry::getValue));
                Collections.reverse(list);
                int i = 0;
                Map<String, Integer> res = new LinkedHashMap<>(list.size());
                for (Map.Entry<String, Integer> entry : list) {
                    i++;
                    res.put(entry.getKey(), entry.getValue());
                    if (i >= 20) {
                        break;
                    }
                }
                hotCar.setBrandContent(JSON.toJSONString(res));
            } else {
                hotCar.setBrandContent(JSON.toJSONString(brandCount));
            }
            searchMapper.updateHotCar(hotCar);
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
        if (queue == null || queue.isEmpty()) {
            return resQueue;
        }
        for (int i = 0; i < 20 && !queue.isEmpty(); i++) {
            resQueue.add(queue.poll());
        }
        return resQueue;
    }

}
