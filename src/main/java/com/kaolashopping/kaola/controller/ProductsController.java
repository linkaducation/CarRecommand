package com.kaolashopping.kaola.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.kaolashopping.kaola.bean.*;
import com.kaolashopping.kaola.redis.RedisUtils;
import com.kaolashopping.kaola.service.CarModelService;
import com.kaolashopping.kaola.service.PersonalizedRecommendationService;
import com.kaolashopping.kaola.service.ProductsService;
import com.kaolashopping.kaola.utils.CookieUtils;
import com.kaolashopping.kaola.utils.LocalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author ming.zhong
 * @date 2018/3/11 上午8:31
 */
@EnableAsync
@RestController
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @Autowired
    private CarModelService carModelService;

    @Autowired
    private PersonalizedRecommendationService prService;

    @Autowired
    private RedisUtils redisUtils;

    @GetMapping(value = {"/index", "/"})
    public ModelAndView homepage(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("homepage");
        User user = LocalUser.getUser();
        LinkedHashMap<String, List<Car>> cars;
        List<Car> hotCars = null;
        String touristCookie = CookieUtils.getTouristCookie(request);
        if (user != null) {
            hotCars = prService.getHotCars(user);
            cars = prService.getHomePageCarsByUser(user);
        } else if (touristCookie != null && redisUtils.get(touristCookie) != null){
            cars = prService.getHomePageCarsByTourist(redisUtils.get(touristCookie));
            hotCars = prService.getHotCars(redisUtils.get(touristCookie));
        } else {
            cars = productsService.getHomePageCars();
        }
        if (hotCars == null || hotCars.isEmpty()) {
            hotCars = productsService.getHotCars();
        }
        mav.addObject("hotCars", hotCars);
        mav.addObject("user", user);
        mav.addObject("cars", cars);
        return mav;
    }

    @GetMapping("/detail/foreproduct/{pId}")
    public ModelAndView foreproduct(@PathVariable("pId") String pId,
                                    HttpServletResponse response) {
        int id = 0;
        try {
            id = Integer.parseInt(pId.replace(",", ""));
        } catch (NumberFormatException e) {
            try {
                response.sendRedirect("/homepage");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        Car car = productsService.getProductById(id);
        if (car != null && car.getParentId() > 0 && car.getisChild()) {
            // 从订单或者购物车跳转商品的情况
            id = car.getParentId();
            car = productsService.getProductById(car.getParentId());
        }
        List<Car> children = productsService.getCarsByParentId(id);
        if (children.isEmpty()) {
            children.add(car);
        }

        Map<String, List<String>> basicConfig = new HashMap<>(children.size());
        Map<String, Set<String>> advantages = new HashMap<>(children.size());

        for (Car child : children) {
            if (child.getEquipment() != null) {
                Map<String, String> carEquipment = JSON.parseObject(child.getEquipment(), new TypeReference<HashMap<String, String>>() {});
                List<String> resList = standardConfig(carEquipment);
                String ids = carEquipment.get("advantage");
                if (ids != null && !Objects.equals(ids, "")) {
                    Set<String> advantage = productsService.getConfigSetByIds(ids);
                    advantages.put(String.valueOf(child.getId()), advantage);
                }
                basicConfig.put(String.valueOf(child.getId()), resList);
            }
        }

        // 获取汽车保值率
        List<Float> premiumRate = carModelService.getPremiumRateByBrand(car);
        premiumRate.sort((o1, o2) -> o1 < o2 ? 1 : -1);
        StringBuilder sb = new StringBuilder();
        for (float rate : premiumRate) {
            sb.append(rate).append(", ");
        }
        User user = LocalUser.getUser();

        // 获取相似车辆信息
        String simIds = car.getSimIds();
        String otherSimIds = car.getOtherSimIds();
        List<Car> simCars = productsService.getSimCarsByIds(simIds);
        List<Car> otherSimCars = productsService.getOtherSimCarsByIds(otherSimIds);
        if (car.getMinPrice() > 0 && simCars != null && otherSimCars != null) {
            final int standardPrice = car.getMinPrice();
            Comparator<Car> comparator = (o1, o2) -> {
                if (o1.getMinPrice() > 0 && o2.getMinPrice() > 0) {
                    int o1Price = Math.abs(o1.getMinPrice() - standardPrice);
                    int o2Price = Math.abs(o2.getMinPrice() - standardPrice);
                    if (o1Price == o2Price) {
                        return 0;
                    }
                    return o1Price > o2Price ? 1 : -1;
                }
                return 0;
            };
            Collections.sort(simCars, comparator);
            Collections.sort(otherSimCars, comparator);
            simCars.addAll(otherSimCars);
        }
        ModelAndView mav = new ModelAndView("foreproduct");
        mav.addObject("user", user);
        mav.addObject("car", car);
        mav.addObject("childrent", children);
        mav.addObject("premiumRate", sb.toString());
        mav.addObject("basicConfigs", basicConfig);
        mav.addObject("advantages", advantages);
        mav.addObject("defaultId", String.valueOf(children.get(0).getId()));
        mav.addObject("simCars", simCars);
        return mav;
    }

    @GetMapping("/brand/{brand}")
    public ModelAndView getCarsByBrand(@PathVariable("brand") String brand, HttpServletRequest request) {
        User user = LocalUser.getUser();
        String touristCookie = CookieUtils.getUserCookieByRequest(request);
        List<Car> cars = null;
        if (user != null) {
            cars = prService.getCarsByBrandWithUser(user, brand);
        } else if (touristCookie != null){
            String touristKey = redisUtils.get(touristCookie);
            cars = prService.getCarsByBrandWithTourist(touristKey, brand);
        } else {
            cars = productsService.getCarsByBrand(brand);
        }
        ModelAndView mav = new ModelAndView("car");
        if (cars != null && !cars.isEmpty()) {
            mav.addObject("cars", cars);
        }
        if (LocalUser.getUser() != null) {
            mav.addObject("user", LocalUser.getUser());
        }
        return mav;
    }

    private List<String> standardConfig(Map<String, String> map) {
        List<String> res = new ArrayList<>(map.size());
        for (String key : map.keySet()) {
            if ("hight".equals(key)) {
                res.add("<span>车高:" + map.get(key) + "</span>");
            } else if ("width".equals(key)) {
                res.add("<span>车宽:" + map.get(key) + "</span>");
            } else if ("wheelbase".equals(key)) {
                res.add("<span>轴距:" + map.get(key) + "</span>");
            } else if ("type".equals(key)) {
                res.add("<span>车身类型:" + map.get(key) + "</span>");
            } else if ("drive".equals(key)) {
                res.add("<span>驱动形式:" + map.get(key) + "</span>");
            } else if ("engine".equals(key)) {
                res.add("<span>发动机:" + map.get(key) + "</span>");
            } else if ("intakeType".equals(key)) {
                res.add("<span>进气形式:" + map.get(key) + "</span>");
            } else if ("horsepower".equals(key)) {
                res.add("<span>最大马力:" + map.get(key) + "</span>");
            } else if ("torque".equals(key)) {
                res.add("<span>最大扭矩:" + map.get(key) + "</span>");
            } else if ("transmission".equals(key)) {
                res.add("<span>变速箱:" + map.get(key) + "</span>");
            } else if ("fuelConsumption".equals(key)) {
                res.add("<span>工信油耗:" + map.get(key) + "</span>");
            }
        }
        return res;
    }
}
