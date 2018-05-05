package com.kaolashopping.kaola.service.implement;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.kaolashopping.kaola.bean.*;
import com.kaolashopping.kaola.mapper.BrandPopularityMapper;
import com.kaolashopping.kaola.mapper.CarMapper;
import com.kaolashopping.kaola.mapper.PersonallizMapper;
import com.kaolashopping.kaola.mapper.SearchMapper;
import com.kaolashopping.kaola.service.PersonalizedRecommendationService;
import com.kaolashopping.kaola.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonalizedRecommendationServiceImpl implements PersonalizedRecommendationService {

    @Autowired
    private PersonallizMapper personallizMapper;

    @Autowired
    private CarMapper carMapper;

    @Autowired
    private ProductsService productsService;

    @Autowired
    private BrandPopularityMapper brandPopularityMapper;

    @Autowired
    private SearchMapper searchMapper;

    /**
     * 非登录用户更新个性化推荐
     *
     * @param touristKey userInfo中的userId
     * @param brand
     * @return
     */
    @Async
    @Override
    public void updatePerRecommandByBrand(String touristKey, String brand) {
        TouristUser touristUser = personallizMapper.getTouristUserByTouristKey(touristKey);
        if (touristUser == null) {
            personallizMapper.addTouristUser(new TouristUser(touristKey));
            touristUser = personallizMapper.getTouristUserByTouristKey(touristKey);
        }
        executeBrandUpdate("tourist", touristUser.getId(), brand);
    }

    /**
     * 登录用户更新个性化推荐
     *
     * @param brand
     * @return
     */
    @Async
    @Override
    public void updatePerRecommandByBrand(String brand, User user) {
        executeBrandUpdate("user", user.getId(), brand);
    }

    /**
     * 用户访问某个品牌后更新该用户的汽车热度推荐
     *
     * @param type
     * @param userId
     * @param brand
     */
    private void executeBrandUpdate(String type, int userId, String brand) {
        UserBrand userBrand = personallizMapper.getUserBrand(userId, type);
        Car car = carMapper.getCarsByBrandNew(brand);

        // 插入品牌浏览记录
        BrandBrowsingHistory bbh = new BrandBrowsingHistory(userId, car.getId(), brand, new Date());
        personallizMapper.saveBrandBrowsingHistory(bbh);

        if (userBrand == null) {
            Map<Integer, Integer> content = new HashMap<>();
            content.put(car.getId(), 1);
            userBrand = new UserBrand(userId, type, JSON.toJSONString(content));
            personallizMapper.addUserBrand(userBrand);
        } else {
            String contentString = userBrand.getContent();
            HashMap<Integer, Integer> content;
            if (contentString == null) {
                content = new HashMap<>();
            } else {
                content = JSON.parseObject(contentString, new TypeReference<HashMap<Integer, Integer>>() {
                });
            }
            if (content.containsKey(car.getId())) {
                content.put(car.getId(), content.get(car.getId()) + 1);
            } else {
                content.put(car.getId(), 1);
            }
            userBrand.setContent(JSON.toJSONString(content));
            personallizMapper.updateUserBrand(userBrand);
        }

    }

    /**
     * 用户访问某个汽车后更新该用户的汽车热度推荐
     *
     * @param type
     * @param userId
     * @param carId
     */
    private void executeUserCarsUpdate(String type, int userId, int carId) {
        Car parentCar = carMapper.getParentByChildId(carId);
        executeBrandUpdate(type, userId, parentCar.getBrand());
        // 插入汽车浏览记录
        CarBrowsingHistory cbh = new CarBrowsingHistory(userId, carId, new Date());
        personallizMapper.saveCarBrowsingHistory(cbh);

        UserCar userCar = personallizMapper.getUserCar(userId, type, parentCar.getId());
        if (userCar == null) {
            Map<Integer, Integer> content = new HashMap<>();
            content.put(carId, 1);
            userCar = new UserCar(userId, type, JSON.toJSONString(content), parentCar.getId());
            personallizMapper.addUserCar(userCar);
        } else {
            String contentString = userCar.getContent();
            HashMap<Integer, Integer> content;
            if (contentString == null) {
                content = new HashMap<>();
            } else {
                content = JSON.parseObject(contentString, new TypeReference<HashMap<Integer, Integer>>() {
                });
            }
            if (content.containsKey(carId)) {
                content.put(carId, content.get(carId) + 1);
            } else {
                content.put(carId, 1);
            }
            userCar.setContent(JSON.toJSONString(content));
            personallizMapper.updateUserCar(userCar);
        }

        HotCarForBrowsing hcfb = personallizMapper.getHotCarForBrowsing(userId, type);
        Map<Integer, Integer> content = new HashMap<>(1);
        content.put(carId, 1);
        if (hcfb == null) {
            hcfb = new HotCarForBrowsing(userId, type, JSON.toJSONString(content));
            personallizMapper.saveHotCarForBrowsing(hcfb);
        } else {
            String contentStr = hcfb.getContent();
            if (contentStr == null) {
                hcfb.setContent(JSON.toJSONString(content));
            } else {
                LinkedHashMap<Integer, Integer> contentMap = JSON.parseObject(contentStr, new TypeReference<LinkedHashMap<Integer, Integer>>() {
                });
                contentMap.put(carId, contentMap.containsKey(carId) ? contentMap.get(carId) + 1 : 1);
                hcfb.setContent(JSON.toJSONString(contentMap));
            }
            personallizMapper.updateHotCarForBrowsing(hcfb);
        }

    }

    /**
     * 登录用户根据访问的车辆id更新个性化推荐
     *
     * @param pid
     * @return
     */
    @Async
    @Override
    public void updatePerRecommandByCar(int pid, User user) {
        executeUserCarsUpdate("user", user.getId(), pid);
    }

    /**
     * 非登录用户根据访问的车辆id更新个性化推荐
     *
     * @param pid
     * @return
     */
    @Async
    @Override
    public void updatePerRecommandByCar(String touristKey, int pid) {
        TouristUser touristUser = personallizMapper.getTouristUserByTouristKey(touristKey);
        if (touristUser == null) {
            personallizMapper.addTouristUser(new TouristUser(touristKey));
            touristUser = personallizMapper.getTouristUserByTouristKey(touristKey);
        }
        executeUserCarsUpdate("tourist", touristUser.getId(), pid);
    }

    /**
     * 登录用户根据搜索条件更新个性化推荐
     *
     * @param scores
     * @return
     */
    @Async
    @Override
    public void updatePerRecommandByScore(Map<String, Float> scores) {

    }

    /**
     * 根据用户获取品牌下的汽车列表
     *
     * @param user
     * @return
     */
    @Override
    public List<Car> getCarsByBrandWithUser(User user, String brand) {
        return getCarsByBrand(user.getId(), "user", brand);
    }

    /**
     * 获取主页汽车菜单
     *
     * @param user
     * @return
     */
    @Override
    public LinkedHashMap<String, List<Car>> getHomePageCarsByUser(User user) {
        return getHomePage(user.getId(), "user");
    }

    /**
     * 获取非登录用户首页的所有car信息
     *
     * @param touristKey
     * @return
     */
    @Override
    public LinkedHashMap<String, List<Car>> getHomePageCarsByTourist(String touristKey) {
        TouristUser touristUser = personallizMapper.getTouristUserByTouristKey(touristKey);
        if (touristUser == null) {
            personallizMapper.addTouristUser(new TouristUser(touristKey));
            touristUser = personallizMapper.getTouristUserByTouristKey(touristKey);
        }
        return getHomePage(touristUser.getId(), "tourist");
    }

    /**
     * 非登录用户通过品牌获取该非登录用户的car
     *
     * @param touristKey
     * @param brand
     * @return
     */
    @Override
    public List<Car> getCarsByBrandWithTourist(String touristKey, String brand) {
        TouristUser touristUser = personallizMapper.getTouristUserByTouristKey(touristKey);
        if (touristUser != null) {
            return getCarsByBrand(touristUser.getId(), "tourist", brand);
        }
        return null;
    }

    /**
     * 根据用户获取主页登陆的热门汽车
     * 1.用户搜索结果hotCar集合
     * 2.用户浏览记录的hotCar集
     *
     * @param user
     * @return
     */
    @Override
    public List<Car> getHotCars(User user) {
        Map<Integer, Car> allCars = productsService.getAllCars();
        HotCar hotCar = searchMapper.getHotCarByUser(user.getId());
        List<Car> res = new ArrayList<>(10);
        String carContent = hotCar.getCarContent();
        LinkedHashMap<Integer, Integer> idCount = JSON.parseObject(carContent,
                new TypeReference<LinkedHashMap<Integer, Integer>>() {
                });
        int i = 0;
        for (Integer carId : idCount.keySet()) {
            Car car = allCars.get(carId);
            if (car != null) {
                res.add(car);
                i++;
            }
            if (i >= 10) {
                break;
            }
        }

        List<UserCar> userCars = personallizMapper.getAllUserCar(user.getId(), "user");


        return res;
    }

    /**
     * 通过汽车品牌获取按照热度排名的car
     *
     * @param userId
     * @param type
     * @param brand
     * @return
     */
    private List<Car> getCarsByBrand(int userId, String type, String brand) {
        Car car = carMapper.getCarsByBrandNew(brand);
        if (car == null) {
            return null;
        }
        UserCar userCar = personallizMapper.getUserCar(userId, type, car.getId());
        if (userCar != null && userCar.getContent() != null) {
            String carContentString = userCar.getContent();
            HashMap<Integer, Integer> carContent = JSON.parseObject(carContentString, new TypeReference<HashMap<Integer, Integer>>() {
            });
            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(carContent.entrySet());
            list.sort((o1, o2) -> {
                if (o1.getValue().equals(o2.getValue())) {
                    return 0;
                }
                return o1.getValue() > o2.getValue() ? -1 : 1;
            });
            StringBuilder cars = new StringBuilder();
            List<Car> cars1 = new ArrayList<>(list.size());
            for (Map.Entry<Integer, Integer> entry : list) {
                cars.append(String.valueOf(entry.getKey())).append(",");
                cars1.add(carMapper.getCarById(entry.getKey()));
            }
            cars.deleteCharAt(cars.length() - 1);
            List<Car> moreCars = brandPopularityMapper.getMoreCarsByParentId(userCar.getBrandId(), 100, cars.toString());
            cars1.addAll(moreCars);
            return cars1;
        } else {
            return brandPopularityMapper.getAllCarsByParentId(car.getId());
        }
    }

    /**
     * 获取主页显示的所有car
     *
     * @param userId
     * @param type
     * @return
     */
    private LinkedHashMap<String, List<Car>> getHomePage(int userId, String type) {
        UserBrand userBrand = personallizMapper.getUserBrand(userId, type);
        if (userBrand == null || userBrand.getContent() == null) {
            return productsService.getHomePageCars();
        }
        String contentString = userBrand.getContent();
        HashMap<Integer, Integer> content = JSON.parseObject(contentString, new TypeReference<HashMap<Integer, Integer>>() {
        });
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(content.entrySet());
        list.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return 0;
            }
            return o1.getValue() > o2.getValue() ? -1 : 1;
        });
        int limit = 0;
        List<Car> parentCar = new ArrayList<>(list.size());
        for (Map.Entry<Integer, Integer> entry : list) {
            limit++;
            parentCar.add(carMapper.getCarById(entry.getKey()));
            if (limit >= 20) {
                break;
            }
        }
        LinkedHashMap<String, List<Car>> res = new LinkedHashMap<>(parentCar.size());
        for (Car car : parentCar) {
            UserCar userCar = personallizMapper.getUserCar(userId, type, car.getId());
            if (userCar == null || userCar.getContent() == null) {
                List<Car> childrenCar = brandPopularityMapper.getCarsByParentId(car.getId());
                res.put(car.getBrand(), childrenCar);
            } else {
                String carContentString = userCar.getContent();
                HashMap<Integer, Integer> carContent = JSON.parseObject(carContentString, new TypeReference<HashMap<Integer, Integer>>() {
                });
                list = new ArrayList<>(carContent.entrySet());
                list.sort((o1, o2) -> {
                    if (o1.getValue().equals(o2.getValue())) {
                        return 0;
                    }
                    return o1.getValue() > o2.getValue() ? -1 : 1;
                });
                StringBuilder cars = new StringBuilder();
                limit = 0;
                List<Car> cars1 = new ArrayList<>(list.size());
                for (Map.Entry<Integer, Integer> entry : list) {
                    limit++;
                    cars.append(String.valueOf(entry.getKey())).append(",");
                    cars1.add(carMapper.getCarById(entry.getKey()));
                    if (limit >= 10) {
                        break;
                    }
                }
                cars.deleteCharAt(cars.length() - 1);
                int len = cars1.size();
                if (len < 10) {
                    cars1.addAll(brandPopularityMapper.getMoreCarsByParentId(car.getId(), 10 - len, cars.toString()));
                }
                res.put(car.getBrand(), cars1);
            }
        }

        int len = res.size();
        if (res.size() < 20) {
            StringBuilder brandSb = new StringBuilder();
            for (String brand : res.keySet()) {
                brandSb.append("'").append(brand).append("'").append(",");
            }
            brandSb.deleteCharAt(brandSb.length() - 1);
            List<BrandPopularity> brandPopularities = brandPopularityMapper.getMoreBrand(brandSb.toString(), 20 - len);
            for (BrandPopularity brandPopularity : brandPopularities) {
                List<Car> chilrendCars = brandPopularityMapper.getChildrenByBrand(brandPopularity.getBrand());
                res.put(brandPopularity.getBrand(), chilrendCars);
            }
        }
        return res;
    }

}
