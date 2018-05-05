package com.kaolashopping.kaola.intercepter;

import com.alibaba.fastjson.JSON;
import com.kaolashopping.kaola.bean.Car;
import com.kaolashopping.kaola.bean.User;
import com.kaolashopping.kaola.redis.RedisUtils;
import com.kaolashopping.kaola.utils.CookieUtils;
import com.kaolashopping.kaola.utils.LocalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author ming.zhong
 * @date 2018/3/10 下午6:55
 */
@Component
public class IgnorePageInterceptier implements HandlerInterceptor {

    @Autowired
    private RedisUtils redisUtils;

    @Value("${personal.userCacheTime}")
    private int USER_CACHE_TIME;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        User user = LocalUser.getUser();
        if (user != null) {
            return true;
        }
        String uid = CookieUtils.getUserCookieByRequest(request);
        String userInfo = redisUtils.get(uid);
        String md5Crypt = CookieUtils.getMd5Crypt(request);
        if (userInfo != null && md5Crypt != null) {
            user = JSON.parseObject(userInfo, User.class);
            LocalUser.setUser(user);
            redisUtils.addByExpire(uid, userInfo, USER_CACHE_TIME, TimeUnit.MINUTES);
        }

        if (LocalUser.getUser() == null) {
            String touristUid = CookieUtils.getTouristCookie(request);
            String cache = redisUtils.get(touristUid);
            if (touristUid == null || cache == null) {
                CookieUtils.setTouristCookie(response, request);
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
        LocalUser.removeUser();
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
