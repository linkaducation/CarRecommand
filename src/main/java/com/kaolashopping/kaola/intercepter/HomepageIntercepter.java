package com.kaolashopping.kaola.intercepter;

import com.kaolashopping.kaola.bean.User;
import com.kaolashopping.kaola.utils.LocalUser;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ming.zhong
 * @date 2018/3/10 下午7:03
 */
@Component
public class HomepageIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        User user = LocalUser.getUser();
        if (user != null) {
            return true;
        }
        String uri = request.getRequestURI();
        if (!uri.contains("login") && !uri.contains("register")) {
            response.sendRedirect("/homepage");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
