package com.kaolashopping.kaola.service;

import com.kaolashopping.kaola.bean.Car;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author ming.zhong
 * @date 2018/3/11 上午8:32
 */
public interface ProductsService {

    /**
     * @return 获取首页显示的汽车信息
     */
    LinkedHashMap<String, List<Car>> getHomePageCars();

    /**
     * 根据ID获取车辆详情
     *
     * @param pId
     * @return
     */
    Car getProductById(int pId);

    List<Car> getCarsByParentId(int pId);

    List<Car> getCarsByBrand(String brand);

    Set<String> getConfigSetByIds(String ids);

    Map<Integer, Car> getAllCars();

    List<Car> getSimCarsByIds(String simIds);

    List<Car> getOtherSimCarsByIds(String otherSimIds);

    void updatePopularity(int pid);

    void updateBrandPopularity(String brand);

    Car getParentCarByChildId(int childId);

}
