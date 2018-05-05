package com.kaolashopping.kaola.service.implement;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.kaolashopping.kaola.bean.Car;
import com.kaolashopping.kaola.mapper.BrandPopularityMapper;
import com.kaolashopping.kaola.mapper.CarMapper;
import com.kaolashopping.kaola.redis.RedisUtils;
import com.kaolashopping.kaola.service.ProductsService;
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

    /**
     * 根据id获取car
     *
     * @param id
     * @return
     */
    @Override
    public Car getCarById(int id) {
        return carMapper.getCarById(id);
    }

    /**
     * 获取主页默认显示的热门车辆集合
     *
     * @return
     */
    @Override
    public List<Car> getHotCars() {
        return carMapper.getHotCars();
    }

}
