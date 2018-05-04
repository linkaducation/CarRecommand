package com.kaolashopping.kaola.utils;


import com.kaolashopping.kaola.bean.User;

/**
 * @author ming.zhong
 * @date 2018/2/17 上午1:12
 */
public class LocalUser {

    private static ThreadLocal<User> LOCAL = new ThreadLocal<>();

    public LocalUser() {};

    public static User getUser() {
        return LOCAL.get();
    }

    public static void setUser(User user) {
        LOCAL.set(user);
    }

    public static void removeUser() {
        LOCAL.remove();
    }
}
