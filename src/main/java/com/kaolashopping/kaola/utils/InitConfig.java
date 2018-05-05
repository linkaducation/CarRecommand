package com.kaolashopping.kaola.utils;

import com.kaolashopping.kaola.bean.Car;
import com.kaolashopping.kaola.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitConfig implements CommandLineRunner {

    @Autowired
    private CarMapper carMapper;

    @Override
    public void run(String... strings) throws Exception {
        CommonUtils.carModelConfig.put("小型SUV", new ArrayList<String>() {{add("紧凑型SUV"); add("中型SUV");}});
        CommonUtils.carModelConfig.put("紧凑型SUV", new ArrayList<String>() {{add("小型SUV"); add("中型SUV");}});
        CommonUtils.carModelConfig.put("中型SUV", new ArrayList<String>() {{add("紧凑型SUV"); add("中大型SUV");}});
        CommonUtils.carModelConfig.put("中大型SUV", new ArrayList<String>() {{add("中型SUV"); add("大型SUV");}});
        CommonUtils.carModelConfig.put("大型SUV", new ArrayList<String>() {{add("微型车"); add("中大型SUV");}});
        CommonUtils.carModelConfig.put("微型车", new ArrayList<String>() {{add("小型车"); add("紧凑型车");}});
        CommonUtils.carModelConfig.put("小型车", new ArrayList<String>() {{add("紧凑型车"); add("中型车");}});
        CommonUtils.carModelConfig.put("紧凑型车", new ArrayList<String>() {{add("小型车"); add("中型车");}});
        CommonUtils.carModelConfig.put("中型车", new ArrayList<String>() {{add("小型车"); add("中大型车");}});
        CommonUtils.carModelConfig.put("中大型车", new ArrayList<String>() {{add("中型车"); add("大型车");}});
        CommonUtils.carModelConfig.put("大型车", new ArrayList<String>() {{add("MPV"); add("中大型车");}});
        CommonUtils.carModelConfig.put("MPV", new ArrayList<String>() {{add("大型车");}});
        CommonUtils.carModelConfig.put("跑车", new ArrayList<String>() {});
        CommonUtils.carModelConfig.put("面包车", new ArrayList<String>() {});

        CommonUtils.carType.put(0, "微型车");
        CommonUtils.carType.put(1, "紧凑型车");
        CommonUtils.carType.put(2, "小型车");
        CommonUtils.carType.put(3, "中型车");
        CommonUtils.carType.put(4, "中大型车");
        CommonUtils.carType.put(5, "大型车");
        CommonUtils.carType.put(6, "紧凑型SUV");
        CommonUtils.carType.put(7, "小型SUV");
        CommonUtils.carType.put(8, "中型SUV");
        CommonUtils.carType.put(9, "中大型SUV");
        CommonUtils.carType.put(10, "大型SUV");
        CommonUtils.carType.put(11, "面包车");
        CommonUtils.carType.put(12, "MPV");
        CommonUtils.carType.put(13, "跑车");
        CommonUtils.carType.put(14, null);

        List<Car> cars = carMapper.getAllMidCar();
        for (Car car : cars) {
            if (car.getId() >= 0 && !car.getType().equals("")) {
                CommonUtils.allCars.put(car.getId(), car);
            }
        }
    }
}
