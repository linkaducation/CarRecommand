package com.kaolashopping.kaola.intercepter;

import com.kaolashopping.kaola.bean.Car;
import com.kaolashopping.kaola.mapper.CarMapper;
import com.kaolashopping.kaola.redis.RedisUtils;
import com.kaolashopping.kaola.service.PersonalizedRecommendationService;
import com.kaolashopping.kaola.service.ProductsService;
import com.kaolashopping.kaola.service.SearchService;
import com.kaolashopping.kaola.utils.CookieUtils;
import com.kaolashopping.kaola.utils.LocalUser;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@EnableAsync
@Component
public class PersonalFeatureIntercepter implements HandlerInterceptor {

    @Autowired
    private ProductsService productsService;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private PersonalizedRecommendationService perRecommentService;

    @Autowired
    private SearchService searchService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String requestURI = request.getRequestURI();
        String touristKey = null;
        if (LocalUser.getUser() == null) {
            String touristCookie = CookieUtils.getTouristCookie(request);
            touristKey = redisUtils.get(touristCookie);
        }

        if (requestURI.contains("detail")) {
            // 更新某辆车的热度
            String pid = null;
            String pattern = ".*/detail/foreproduct/(.*)";
            Pattern compilePattern = Pattern.compile(pattern);
            Matcher matcher = compilePattern.matcher(requestURI);
            if (matcher.find()) {
                pid = matcher.group(1);
            }
            if (pid != null) {
                int id = Integer.parseInt(pid.replaceAll(",", ""));
                productsService.updatePopularity(id);
                Car car = productsService.getParentCarByChildId(id);

                if (LocalUser.getUser() != null) {
                    perRecommentService.updatePerRecommandByCar(id, LocalUser.getUser());
                } else if (touristKey != null) {
                    perRecommentService.updatePerRecommandByCar(touristKey, id);
                }

                if (car != null) {
                    updateBrandPopularity(car.getBrand());
                }

                String referer = request.getHeader("Referer");
                if (referer != null && referer.contains("search")) {
                    List<Car> cars = new ArrayList<>(1);
                    cars.add(productsService.getCarById(id));
                    if (LocalUser.getUser() != null) {
                        searchService.updateUserRecommand(cars, LocalUser.getUser().getId());
                    }
                }
            }
        } else if (requestURI.contains("brand")) {
            // 更新某个品牌的热度
            String brand = null;
            String pattern = ".*/brand/(.*)";
            Pattern compilePattern = Pattern.compile(pattern);
            Matcher matcher = compilePattern.matcher(requestURI);
            if (matcher.find()) {
                brand = matcher.group(1);
                brand = URLDecoder.decode(brand, "utf-8");
            }
            if (brand != null) {

                if (LocalUser.getUser() != null) {
                    perRecommentService.updatePerRecommandByBrand(brand, LocalUser.getUser());
                } else if (touristKey != null) {
                    perRecommentService.updatePerRecommandByBrand(touristKey, brand);
                }
                updateBrandPopularity(brand);
            }
        }

        return true;
    }

    private void updateBrandPopularity(String brand) {
        productsService.updateBrandPopularity(brand);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {

    }
}
