package com.kaolashopping.kaola.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * @author ming.zhong
 * @date 2018/2/14 下午2:24
 */
@Component
public class RedisUtils {

    @Autowired
    private RedisTemplate redisTemplate;

    public void removeAll(String[] keys) {
        if (keys.length > 0) {
            redisTemplate.delete(keys);
        }
    }

    public void remove(String key) {
        if (key != null) {
            redisTemplate.delete(key);
        }
    }

    public boolean add(String key, Object value) {
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public String get(String key) {
        if (key == null) {
            return null;
        }
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        Object value = operations.get(key);
        if (value == null) {
            return null;
        }
        return value.toString();
    }

    public boolean addByExpire(String key, Object value, int exp, TimeUnit timeUnit) {
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value, exp, timeUnit);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
