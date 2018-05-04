package com.kaolashopping.kaola.service.implement;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.kaolashopping.kaola.bean.Car;
import com.kaolashopping.kaola.bean.User;
import com.kaolashopping.kaola.mapper.BrandPopularityMapper;
import com.kaolashopping.kaola.mapper.CarMapper;
import com.kaolashopping.kaola.redis.RedisUtils;
import com.kaolashopping.kaola.service.ProductsService;
import com.kaolashopping.kaola.utils.LocalUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author ming.zhong
 * @date 2018/3/11 上午8:32
 */
@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private CarMapper carMapper;

    @Value("${personal.pageNum}")
    private int pageNum;

    @Autowired
    private RedisUtils redisUtils;

    @Value("${personal.HomePageCarKeys}")
    private String HOME_PAGE_CAR_INFO;

    @Autowired
    private BrandPopularityMapper brandPopularityMapper;

    private static String allCars = "ALLCARSREDISKEY";

    /**
     * 获取默认情况下主页显示的车辆信息
     *
     * @return
     */
    @Override
    public LinkedHashMap<String, List<Car>> getHomePageCars() {
        String rawCarsInfo = redisUtils.get(HOME_PAGE_CAR_INFO);
        LinkedHashMap<String, List<Car>> carInfo;
        if (rawCarsInfo == null) {
            List<Car> parentCars = carMapper.getParentCars();
            carInfo = new LinkedHashMap<>(parentCars.size());
            for (Car parentCar : parentCars) {
                List<Car> childCars = carMapper.getCarsByBrand(parentCar.getId(), pageNum);
                if (childCars != null && !childCars.isEmpty()) {
                    carInfo.put(parentCar.getBrand(), childCars);
                }
            }
//            redisUtils.addByExpire(HOME_PAGE_CAR_INFO, JSON.toJSONString(carInfo), 5, TimeUnit.MINUTES);
        } else {
            carInfo = JSON.parseObject(rawCarsInfo, new TypeReference<LinkedHashMap<String, List<Car>>>() {
            });
        }
        return carInfo;
    }

    /**
     * 通过汽车id获取汽车汽车信息
     *
     * @param pId
     * @return
     */
    @Override
    public Car getProductById(int pId) {
        Car parentCar = carMapper.getCarById(pId);
        return parentCar;
    }

    /**
     * 通过parentId获取所有的children
     *
     * @param pId: parentId
     * @return
     */
    @Override
    public List<Car> getCarsByParentId(int pId) {
        List<Car> cars = carMapper.getCarsByParentId(pId);
        return cars;
    }

    /**
     * 通过汽车品牌获取该品牌下的所有car
     *
     * @param brand
     * @return
     */
    @Override
    public List<Car> getCarsByBrand(String brand) {
        List<Car> cars = carMapper.getCarsByBrandName(brand);
        return cars;
    }

    /**
     * 通过ids获取这些汽车所有的配置参数，返回set
     *
     * @param ids
     * @return
     */
    @Override
    public Set<String> getConfigSetByIds(String ids) {
        List<String> advantages = carMapper.getConfigByIds(ids);
        return new HashSet<>(advantages);
    }

    /**
     * 获取所有的有评分的车辆，带缓存
     *
     * @return
     */
    @Override
    public Map<Integer, Car> getAllCars() {
        String carsMap = redisUtils.get(allCars);
        Map<Integer, Car> map;
        if (carsMap == null) {
            List<Car> cars = carMapper.getAllMidCar();
            map = new HashMap<>();
            for (Car car : cars) {
                if (car.getId() >= 0 && !car.getType().equals("")) {
                    map.put(car.getId(), car);
                }
            }
            redisUtils.add(allCars, JSON.toJSONString(map));
        } else {
            map = JSON.parseObject(carsMap, new TypeReference<HashMap<Integer, Car>>() {
            });
        }
        return map;
    }

    /**
     * 通过simIds获取所有的car，该情况下获取的car定位于目标车辆相同
     *
     * @param simIds
     * @return
     */
    @Override
    public List<Car> getSimCarsByIds(String simIds) {
        if (simIds == null || "".equals(simIds)) {
            return null;
        }
        String ids = simIds.replaceAll(" ", ",");
        return carMapper.getCarsByIds(ids);
    }

    /**
     * 通过相似id获取所有car，该情况下获取的相识车辆定位不与目标车辆相同
     *
     * @param otherSimIds
     * @return
     */
    @Override
    public List<Car> getOtherSimCarsByIds(String otherSimIds) {
        if (otherSimIds == null || "".equals(otherSimIds)) {
            return null;
        }
        String ids = otherSimIds.replaceAll(" ", ",");
        return carMapper.getCarsByIds(ids);
    }

    /**
     * 通过car.id更新车辆的热门程度
     *
     * @param pid
     */
    @Override
    public void updatePopularity(int pid) {
        carMapper.updatePopularity(pid);
    }

    /**
     * 通过品牌更新车辆的热门程度
     *
     * @param brand
     */
    @Override
    public void updateBrandPopularity(String brand) {
        brandPopularityMapper.updateBrandPopularity(brand);
    }

    /**
     * 通过car.id获取该car的parentCar
     *
     * @param childId
     * @return
     */
    @Override
    public Car getParentCarByChildId(int childId) {
        return carMapper.getParentByChildId(childId);
    }

}
