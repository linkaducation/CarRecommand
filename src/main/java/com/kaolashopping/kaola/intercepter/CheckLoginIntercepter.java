package com.kaolashopping.kaola.intercepter;

import com.kaolashopping.kaola.bean.User;
import com.kaolashopping.kaola.utils.LocalUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ming.zhong
 * @date 2018/2/14 下午2:01
 */
@Component
public class CheckLoginIntercepter implements HandlerInterceptor {

    @Value("${personal.loginUrl}")
    private String LOGIN_URL;

    /**
     * 拦截所有请求，根据请求cookie获取获取user，
     * @param request
     * @param response
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        User user = LocalUser.getUser();
        if (user != null) {
            return true;
        }
        String uri = request.getRequestURI();
        response.sendRedirect(LOGIN_URL + "?redirect=" + uri);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
