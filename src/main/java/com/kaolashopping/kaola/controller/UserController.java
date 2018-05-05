package com.kaolashopping.kaola.controller;

import com.alibaba.fastjson.JSON;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.kaolashopping.kaola.bean.Car;
import com.kaolashopping.kaola.bean.User;
import com.kaolashopping.kaola.redis.RedisUtils;
import com.kaolashopping.kaola.service.UserService;
import com.kaolashopping.kaola.utils.CookieUtils;
import com.kaolashopping.kaola.utils.LocalUser;
import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author ming.zhong
 * @date 2018/2/14 下午11:56
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private DefaultKaptcha defaultKaptcha;

    @Value("${personal.verifyCodeCacheTime}")
    private int verifyCodeCacheTime;

    @PostMapping("/dologin")
    public String LoginHandler(User user, HttpServletRequest request, HttpServletResponse response) {
        User userFromDB = userService.loginByInstance(user);
        ModelAndView modelAndView = null;
        if (userFromDB != null) {
            String userAgent = request.getHeader("user-agent");
            String remoteHost = request.getRemoteHost();
            String md5Crypt = Md5Crypt.md5Crypt((userAgent + remoteHost).getBytes());
            redisUtils.addByExpire(md5Crypt, JSON.toJSONString(userFromDB), 3, TimeUnit.HOURS);
            modelAndView = new ModelAndView("homepage");
            modelAndView.addObject("user", userFromDB);
            // 添加cookie
            response.addCookie(new Cookie("uid", md5Crypt));
            return "true";
        }
        return "false";
    }

    @GetMapping("/user/login")
    public ModelAndView Login() {
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }

    @GetMapping("/defaultKaptcha")
    public void getVerifyImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            String kaptchaText = defaultKaptcha.createText();
            // 将验证码存入redis中，并且时长只有一分钟
            String redisKey = request.getRemoteAddr();
            redisUtils.addByExpire(redisKey, kaptchaText, verifyCodeCacheTime, TimeUnit.MINUTES);
            BufferedImage challenge = defaultKaptcha.createImage(kaptchaText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);

        } catch (IOException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            e.printStackTrace();
            return;
        }
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = response.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }

    @PostMapping("/doregister")
    public String register(HttpServletRequest request, HttpServletResponse response, User user,
                           @RequestParam("vrifyCode") String vrifyCode) {
        String redisKey = request.getRemoteAddr();
        String captchaId = redisUtils.get(redisKey);
        if (captchaId == null || !captchaId.equals(vrifyCode)) {
            // 验证码校验失败
            return "failed";
        }
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowStr = sdf.format(now);
        user.setAddDate(nowStr).setUpdateDate(nowStr).setIsDeleted(0).setStatus(0);
        user.setStatus(1);
        boolean ret = userService.addUser(user);

        if (ret) {
            CookieUtils.setCookieByUser(response, user, request);
            return "true";
        }
        return "false";
    }

    @GetMapping("/user/register")
    public ModelAndView getIndexPage() {
        return new ModelAndView("register");
    }

    @PostMapping("/check/user")
    public String checkUser(String userName) {
        boolean res = userService.checkUser(userName);
        if (res) {
            return "true";
        }
        return "false";
    }

    @GetMapping("/check/user")
    public String checkLogin() {
        User user = LocalUser.getUser();
        if (user == null) {
            return "false";
        }
        return "true";
    }

    @GetMapping("/user/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        userService.logout(CookieUtils.getUserCookieByRequest(request));
        if (LocalUser.getUser() != null) {
            try {
                response.sendRedirect("/");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @GetMapping("/user/center")
    public ModelAndView personalCenter() {
        // car的最近浏览记录
        List<Car> latestCars = userService.getLatestCar();

        // 浏览最多的car
        List<Car> mostViewCars = userService.getMostViewCars();

        // brand的最近浏览历史
        List<String> brands = userService.getLatestBrands();

        // 浏览最多的品牌
        List<String> mostViewsBrand = userService.getMostViewBrands();

        // 获取我最在意的优点和我最不在乎的缺点
        Map<String, List<String>> features = userService.getPersonFeatures();

        // 获取个人最在意的车辆的三个特征
        List<String> characters = userService.getChracters();

        ModelAndView mav = new ModelAndView("userCenter");
        return mav;
    }
}
