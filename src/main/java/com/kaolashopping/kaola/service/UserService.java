package com.kaolashopping.kaola.service;


import com.kaolashopping.kaola.bean.User;

/**
 * @author ming.zhong
 * @date 2018/2/14 下午11:16
 */
public interface UserService {

    User getUserById(int id);

    User loginByInstance(User user);

    boolean addUser(User user);

    boolean checkUser(String userName);
}
