package com.kaolashopping.kaola.service;

import com.kaolashopping.kaola.bean.Car;
import com.kaolashopping.kaola.bean.CarModel;
import com.kaolashopping.kaola.bean.OveragePremiumRateOfCarUsingAge;

import java.util.List;

/**
 * @author ming.zhong
 * @date 2018/3/24 下午9:56
 */
public interface CarModelService {

    List<OveragePremiumRateOfCarUsingAge> initCarModel();

    List<Float> getPremiumRateByBrand(Car car);

    boolean initPear();

}
