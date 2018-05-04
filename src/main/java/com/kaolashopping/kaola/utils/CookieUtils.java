package com.kaolashopping.kaola.utils;

import com.alibaba.fastjson.JSON;
import com.kaolashopping.kaola.bean.User;
import com.kaolashopping.kaola.redis.RedisUtils;
import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * @author ming.zhong
 * @date 2018/2/17 上午12:32
 */
@Component
public class CookieUtils {

    private static RedisUtils redisUtils;

    private static String cookieName;

    private static String touristCookieName;

    @Value("${personal.touristCookieName}")
    public void setTouristCookieName(String touristCookieName) {
        CookieUtils.touristCookieName = touristCookieName;
    }

    @Value("${personal.cookieName}")
    public void setCookieName(String cookieName) {
        CookieUtils.cookieName = cookieName;
    }

    @Autowired
    public void setRedisUtils(RedisUtils redisUtils) {
        CookieUtils.redisUtils = redisUtils;
    }

    /**
     * 获取用户cookie信息
     *
     * @param request
     * @return
     */
    public static String getUserCookieByRequest(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookieName.equals(cookie.getName())) {
                return cookie.getValue();
            }
        }
        return null;
    }

    /**
     * 获取非登陆用户cookie
     *
     * @param request
     * @return
     */
    public static String getTouristCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (touristCookieName.equals(cookie.getName())) {
                return cookie.getValue();
            }
        }
        return null;
    }

    /**
     * 设置cookie
     *
     * @param response
     * @param user
     * @param request
     * @return
     */
    public static boolean setCookieByUser(HttpServletResponse response, User user,
                                          HttpServletRequest request) {
        String userAgent = request.getHeader("user-agent");
        String remoteHost = request.getRemoteHost();
        String md5Crypt = Md5Crypt.md5Crypt((userAgent + remoteHost).getBytes());
        response.addCookie(new Cookie(cookieName, md5Crypt));
        try {
            redisUtils.addByExpire(md5Crypt, JSON.toJSONString(user), 3, TimeUnit.HOURS);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 设置非登录用户cookie
     *
     * @param response
     * @param request
     * @return
     */
    public static boolean setTouristCookie(HttpServletResponse response, HttpServletRequest request) {
        if (request.getRequestURI().contains("img")) {
            return true;
        }
        String userAgent = request.getHeader("user-agent");
        String remoteHost = request.getRemoteHost();
        String md5Crypt = Md5Crypt.md5Crypt((userAgent + remoteHost).getBytes());
        boolean exist = false;
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals(touristCookieName)) {
                    cookie.setPath("/");
                    cookie.setValue(md5Crypt);
                    response.addCookie(cookie);
                    exist = true;
                }
            }
        }
        if (!exist) {
            Cookie cookie = new Cookie(touristCookieName, md5Crypt);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        try {
            redisUtils.addByExpire(md5Crypt, md5Crypt + "tourist", 3, TimeUnit.HOURS);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 获取用户对用的redis key
     *
     * @param request
     * @return
     */
    public static String getMd5Crypt(HttpServletRequest request) {
        String userAgent = request.getHeader("user-agent");
        String remoteHost = request.getRemoteHost();
        if (userAgent == null || remoteHost == null) {
            return null;
        }
        return Md5Crypt.md5Crypt((userAgent + remoteHost).getBytes());
    }
}
