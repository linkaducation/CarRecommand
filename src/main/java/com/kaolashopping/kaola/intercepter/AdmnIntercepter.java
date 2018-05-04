package com.kaolashopping.kaola.intercepter;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author ming.zhong
 * @date 2018/3/24 下午10:58
 */
@Component
public class AdmnIntercepter implements HandlerInterceptor{

    private static String adminKey = "ZUIAIPANDABABY";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("uid".equals(cookie.getName())) {
                if (adminKey.equals(cookie.getValue())) {
                    return true;
                }
            }
        }
        PrintWriter writer = response.getWriter();
        writer.append("access deny");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
