package com.kaolashopping.kaola.utils;


import com.kaolashopping.kaola.bean.Car;
import com.kaolashopping.kaola.bean.User;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ming.zhong
 * @date 2018/3/10 下午5:47
 */
public class CommonUtils {

    public static Map<String, List<String>> carModelConfig = new HashMap<>();

    public static Map<Integer, String> carType = new HashMap<>();

    public static String getPassword(String password) {
        return DigestUtils.md5Hex(password);
    }

    public final static Map<Integer, Car> allCars = new HashMap<>();

    public static String getOrderId() {
        User user = LocalUser.getUser();
        Date now = new Date();
        return String.valueOf(now.getTime()) + String.valueOf(user.getId());
    }


    /**
     * totalCount: 总的比较的条件
     * totalScore1：第一个对象所有条件的总和
     * totalScore2: 第二个对象所有条件的总和
     * totalSq1： 第一个对象所有条件的平方和
     * totalSq2： 第二个对象所有条件的平方和
     * totalX： 两个对象对应条件的乘积和
     *
     * @param evaluate1
     * @param evaluate2
     * @return
     */
    public static float getPearsonCoefficient(Map<String, Float> evaluate1, Map<String, Float> evaluate2) {
        int totalCount = 0;
        float totalScore1 = 0;
        float totalScore2 = 0;
        float totalSq1 = 0;
        float totalSq2 = 0;
        float totalXY = 0;
        for (String s : evaluate1.keySet()) {
            if (evaluate2.containsKey(s) && evaluate1.get(s) > 0 && evaluate2.get(s) > 0) {
                totalCount++;
                totalScore1 += evaluate1.get(s);
                totalScore2 += evaluate2.get(s);
                totalSq1 += Math.pow(evaluate1.get(s), 2);
                totalSq2 += Math.pow(evaluate2.get(s), 2);
                totalXY += evaluate1.get(s) * evaluate2.get(s);
            }
        }
        double numerator = totalXY - totalScore1 * totalScore2 / totalCount;
        double denominator = Math.sqrt((totalSq1 - Math.pow(totalScore1, 2) / totalCount) * (totalSq2 - Math.pow(totalScore2, 2) / totalCount));
        if (denominator == 0) {
            return 0;
        }
        return Float.valueOf(String.valueOf(numerator / denominator));
    }
}
