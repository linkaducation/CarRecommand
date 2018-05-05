package com.kaolashopping.kaola.controller;

import com.kaolashopping.kaola.bean.Car;
import com.kaolashopping.kaola.bean.User;
import com.kaolashopping.kaola.redis.RedisUtils;
import com.kaolashopping.kaola.service.SearchService;
import com.kaolashopping.kaola.utils.CookieUtils;
import com.kaolashopping.kaola.utils.LocalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author ming.zhong
 * @date 2018/4/7 上午10:49
 */
@RestController
public class CarSearchController {

    @Autowired
    private SearchService searchService;

    @Autowired
    private RedisUtils redisUtils;

    @PostMapping("/search")
    public ModelAndView SearchCars(@RequestParam Map<String, String> searchCondition,
                                   HttpServletRequest request, HttpServletResponse response) {
        User user = LocalUser.getUser();
        List<Car> simCars = null;
        String touristCookie = CookieUtils.getTouristCookie(request);
        if (searchCondition.get("type").equals("选择")) {
            searchCondition.put("type", "14");
        }
        if (user != null) {
            simCars = searchService.getSimCars(searchCondition);
        } else if (touristCookie != null && redisUtils.get(touristCookie) != null) {
            simCars = searchService.getSimCars(searchCondition, redisUtils.get(touristCookie));
        } else {
            try {
                response.sendRedirect("/homepage");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ModelAndView mav = new ModelAndView("search");
        mav.addObject("simCars", simCars);
        mav.addObject("user", LocalUser.getUser());
        return mav;
    }

    @GetMapping("/search")
    public void SearchCars(HttpServletResponse response) {
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
