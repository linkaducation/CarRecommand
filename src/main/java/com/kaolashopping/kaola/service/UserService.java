package com.kaolashopping.kaola.service;


import com.kaolashopping.kaola.bean.Car;
import com.kaolashopping.kaola.bean.User;

import java.util.List;
import java.util.Map;

/**
 * @author ming.zhong
 * @date 2018/2/14 下午11:16
 */
public interface UserService {

    User getUserById(int id);

    User loginByInstance(User user);

    boolean addUser(User user);

    boolean checkUser(String userName);

    List<Car> getLatestCar();

    List<String> getLatestBrands();

    Map<String,List<String>> getPersonFeatures();

    List<String> getChracters();

    List<Car> getMostViewCars();

    List<String> getMostViewBrands();

    void logout(String uid);
}
