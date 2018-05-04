package com.kaolashopping.kaola.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.kaolashopping.kaola.bean.Car;
import com.kaolashopping.kaola.bean.OveragePremiumRateOfCarUsingAge;
import com.kaolashopping.kaola.service.CarModelService;
import com.kaolashopping.kaola.service.ProductsService;
import com.kaolashopping.kaola.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author ming.zhong
 * @date 2018/3/24 下午10:54
 */
@RestController
public class CarModelController {

    @Autowired
    private CarModelService carModelService;

    @Autowired
    private ProductsService productsService;

    @GetMapping("/admin/initModel")
    public List<OveragePremiumRateOfCarUsingAge> initCarModel() {
        return carModelService.initCarModel();
    }

    @GetMapping("/admin/initPearCF")
    public boolean getPearsonCoefficient() {
        carModelService.initPear();
        return true;
    }

}
