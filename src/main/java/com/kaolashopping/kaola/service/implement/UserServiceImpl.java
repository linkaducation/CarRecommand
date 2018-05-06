package com.kaolashopping.kaola.service.implement;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.kaolashopping.kaola.bean.*;
import com.kaolashopping.kaola.mapper.PersonallizMapper;
import com.kaolashopping.kaola.mapper.UserMapper;
import com.kaolashopping.kaola.redis.RedisUtils;
import com.kaolashopping.kaola.service.UserService;
import com.kaolashopping.kaola.utils.CommonUtils;
import com.kaolashopping.kaola.utils.LocalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * @author ming.zhong
 * @date 2018/2/14 下午11:16
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PersonallizMapper personallizMapper;

    @Autowired
    private RedisUtils redisUtils;

    /**
     * 通过用户id获取user
     *
     * @param id
     * @return
     */
    @Override
    public User getUserById(int id) {
        User user = userMapper.getUserById(id);
        if (user == null) {
            return null;
        }
        return user;
    }

    /**
     * 登陆
     *
     * @param user
     * @return
     */
    @Override
    public User loginByInstance(User user) {
        User userFromDB = userMapper.getUserByIntance(user);
        if (userFromDB != null) {
            LocalUser.setUser(userFromDB);
        }
        return userFromDB;
    }

    /**
     * 添加用户， 注册用户
     *
     * @param user
     * @return
     */
    @Override
    public boolean addUser(User user) {
        User tmpUser = userMapper.getUserByUserName(user.getUserName());
        if (tmpUser != null) {
            return false;
        }
        userMapper.addUser(user);
        return true;
    }

    /**
     * 用户下线
     */
    @Override
    public void logout(String uid) {
        redisUtils.remove(uid);
    }

    /**
     * 检查userName是否已经被使用
     *
     * @param userName
     * @return
     */
    @Override
    public boolean checkUser(String userName) {
        User user = userMapper.getUserByUserName(userName);
        if (user == null) {
            return true;
        }
        return false;
    }

    /**
     * 获取用户最近的车辆浏览历史
     * 最近的10条
     *
     * @return
     */
    @Override
    public List<Car> getLatestCar() {
        User user = LocalUser.getUser();
        List<CarBrowsingHistory> carBrowsingHistories = personallizMapper.getLatestCarBrowsing(user.getId());
        if (carBrowsingHistories == null || carBrowsingHistories.isEmpty()) {
            return null;
        }
        return getTop10Car(carBrowsingHistories);
    }

    /**
     * 获取浏览数量最多的car
     *
     * @return
     */
    @Override
    public List<Car> getMostViewCars() {
        User user = LocalUser.getUser();
        List<CarBrowsingHistory> mostViewCars = personallizMapper.getMostViewCars(user.getId());
        if (mostViewCars == null || mostViewCars.isEmpty()) {
            return null;
        }
        return getTop10Car(mostViewCars);
    }

    /**
     * 将CarBrowsingHistory转化为car
     *
     * @param cars
     * @return
     */
    private List<Car> getTop10Car(List<CarBrowsingHistory> cars) {
        Map<Integer, Car> allCars = CommonUtils.allCars;
        List<Car> res = new ArrayList<>(cars.size());
        for (CarBrowsingHistory viewCar : cars) {
            Car car = allCars.get(viewCar.getCarId());
            if (car != null) {
                res.add(car);
            }
        }
        return res;
    }

    /**
     * 获取最近关注的5个汽车品牌
     *
     * @return
     */
    @Override
    public List<String> getLatestBrands() {
        User user = LocalUser.getUser();
        List<BrandBrowsingHistory> brandHistories = personallizMapper.getLatestBrands(user.getId());
        if (brandHistories == null || brandHistories.isEmpty()) {
            return null;
        }
        List<String> res = new ArrayList<>(brandHistories.size());
        for (BrandBrowsingHistory history : brandHistories) {
            res.add(history.getBrand());
        }
        return res;
    }

    /**
     * 获取浏览次数最多的5个品牌
     *
     * @return
     */
    @Override
    public List<String> getMostViewBrands() {
        User user = LocalUser.getUser();
        List<BrandBrowsingHistory> brandHistories = personallizMapper.getMostViewBrands(user.getId());
        if (brandHistories == null || brandHistories.isEmpty()) {
            return null;
        }
        List<String> res = new ArrayList<>(brandHistories.size());
        for (BrandBrowsingHistory history : brandHistories) {
            res.add(history.getBrand());
        }
        return res;
    }

    /**
     * 获取用户特征
     *
     * @return
     */
    @Override
    public Map<String, List<String>> getPersonFeatures() {
        Map<Integer, Integer> carMap = getHotCarsForUser();
        if (carMap == null || carMap.isEmpty()) {
            return null;
        }
        Map<String, Integer> advantagesMap = new HashMap<>();
        Map<String, Integer> disadvantagesMap = new HashMap<>();
        classifyCharacters(advantagesMap, disadvantagesMap, carMap);
        List<String> topAdvantages = getTopCharacters(advantagesMap);
        List<String> topDisadvantages = getTopCharacters(disadvantagesMap);
        Map<String, List<String>> res = new HashMap<>(2);
        res.put("advantage", topAdvantages);
        res.put("disadvantage", topDisadvantages);
        return res;
    }

    /**
     * 获取用户选择汽车最在意的点
     *
     * @return
     */
    @Override
    public List<String> getChracters() {
        class Node {
            int count;
            float totalScore;

            Node(int count, float totalScore) {
                this.count = count;
                this.totalScore = totalScore;
            }
        }
        Map<Integer, Integer> carMap = getHotCarsForUser();
        if (carMap == null || carMap.isEmpty()) {
            return null;
        }
        Map<Integer, Car> allCars = CommonUtils.allCars;
        Map<String, Node> tmpMap = new HashMap<>(9);
        for (Integer carId : carMap.keySet()) {
            Car car = allCars.get(carId);
            if (car == null) {
                continue;
            }
            String evaluate = car.getEvaluate();
            Map<String, Float> evaluateMap = JSON.parseObject(evaluate, new TypeReference<Map<String, Float>>() {
            });
            for (String key : evaluateMap.keySet()) {
                Node node;
                if (tmpMap.containsKey(key)) {
                    node = tmpMap.get(key);
                    node.count += 1;
                    node.totalScore += evaluateMap.get(key);
                } else {
                    node = new Node(1, evaluateMap.get(key));
                }
                tmpMap.put(key, node);
            }
        }
        Map<String, Float> beforeRes = new HashMap<>(tmpMap.size());
        for (String key : tmpMap.keySet()) {
            Node node = tmpMap.get(key);
            beforeRes.put(key, node.totalScore / node.count);
        }
        List<Map.Entry<String, Float>> list = new ArrayList<>(beforeRes.entrySet());
        list.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return 0;
            }
            return o1.getValue().compareTo(o2.getValue());
        });
        Collections.reverse(list);
        List<String> res = new ArrayList<>(3);
        for (int i = 0; i < 3 && i < list.size(); i++) {
            res.add(list.get(i).getKey());
        }
        return transformEnToCn(res);
    }

    /**
     * 获取用户最相关的车辆信息
     *
     * @return
     */
    private Map<Integer, Integer> getHotCarsForUser() {
        HotCarForBrowsing hcfb = personallizMapper.getHotCarForBrowsing(LocalUser.getUser().getId(), "user");
        if (hcfb == null || hcfb.getContent() == null) {
            return null;
        }
        String contentStr = hcfb.getContent();
        return JSON.parseObject(contentStr, new TypeReference<HashMap<Integer, Integer>>() {
        });
    }

    /**
     * 将每辆车的优缺点分类
     *
     * @param advantagesMap
     * @param disadvantageMap
     * @param carMap
     */
    private void classifyCharacters(Map<String, Integer> advantagesMap, Map<String, Integer> disadvantageMap,
                                    Map<Integer, Integer> carMap) {
        Map<Integer, Car> allCars = CommonUtils.allCars;
        for (Integer carId : carMap.keySet()) {
            Car car = allCars.get(carId);
            if (car == null) {
                continue;
            }
            String advantage = car.getAdvantages();
            String disAdvantage = car.getDisAdvantages();
            if (advantage != null && !"".equals(advantage)) {
                String[] advantageStr = advantage.split(",");
                for (String str : advantageStr) {
                    advantagesMap.put(str, advantagesMap.containsKey(str) ? advantagesMap.get(str) + 1 : 1);
                }
            }
            if (disAdvantage != null && !"".equals(disAdvantage)) {
                String[] disadvantageStr = disAdvantage.split(",");
                for (String str : disadvantageStr) {
                    disadvantageMap.put(str, disadvantageMap.containsKey(str) ? disadvantageMap.get(str) + 1 : 1);
                }
            }
        }
    }

    /**
     * 排名前5的特征值
     *
     * @param map
     * @return
     */
    private List<String> getTopCharacters(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Comparator.comparing(Map.Entry::getValue));
        Collections.reverse(list);
        List<String> res = new ArrayList<>(list.size());
        int limit = 1;
        for (Map.Entry<String, Integer> entry : list) {
            res.add(entry.getKey());
            if (limit++ >= 5) {
                break;
            }
        }
        return res;
    }

    /**
     * 将标签由英文转化为中文
     *
     * @param chracters
     * @return
     */
    private List<String> transformEnToCn(List<String> chracters) {
        List<String> res = new ArrayList<>(3);
        for (String chracter : chracters) {
            res.add(CommonUtils.characterMap.get(chracter));
        }
        return res;
    }

}
