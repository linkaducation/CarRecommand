package com.kaolashopping.kaola.service;

import com.kaolashopping.kaola.bean.Car;
import com.kaolashopping.kaola.bean.User;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface PersonalizedRecommendationService {

    void updatePerRecommandByBrand(String touristKey, String brand);

    void updatePerRecommandByBrand(String brand, User user);

    void updatePerRecommandByCar(int pid, User user);

    void updatePerRecommandByCar(String touristKey, int pid);

    void updatePerRecommandByScore(Map<String, Float> scores);

    List<Car> getCarsByBrandWithUser(User user, String brand);

    LinkedHashMap<String,List<Car>> getHomePageCarsByUser(User user);

    LinkedHashMap<String,List<Car>> getHomePageCarsByTourist(String touristKey);

    List<Car> getCarsByBrandWithTourist(String touristKey, String brand);

    List<Car> getHotCars(User user);

    List<Car> getHotCars(String touristKey);
}
