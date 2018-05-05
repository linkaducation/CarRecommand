package com.kaolashopping.kaola.service;

import com.kaolashopping.kaola.bean.Car;

import java.util.List;
import java.util.Map;

public interface SearchService {
    List<Car> getSimCars(Map<String, String> searchCondition);

    List<Car> getSimCars(Map<String, String> searchCondition, String touristKey);

    void updateUserRecommand(List<Car> cars, int userId);
}
