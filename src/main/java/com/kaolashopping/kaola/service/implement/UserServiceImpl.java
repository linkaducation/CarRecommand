package com.kaolashopping.kaola.service.implement;

import com.kaolashopping.kaola.bean.User;
import com.kaolashopping.kaola.mapper.UserMapper;
import com.kaolashopping.kaola.service.UserService;
import com.kaolashopping.kaola.utils.LocalUser;
import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author ming.zhong
 * @date 2018/2/14 下午11:16
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(int id) {
        User user = userMapper.getUserById(id);
        if (user == null) {
            return null;
        }
        return user;
    }

    @Override
    public User loginByInstance(User user) {
        User userFromDB = userMapper.getUserByIntance(user);
        if (userFromDB != null) {
            LocalUser.setUser(userFromDB);
        }
        return userFromDB;
    }

    @Override
    public boolean addUser(User user) {
        User tmpUser = userMapper.getUserByUserName(user.getUserName());
        if (tmpUser != null) {
            return false;
        }
        userMapper.addUser(user);
        return true;
    }

    @Override
    public boolean checkUser(String userName) {
        User user = userMapper.getUserByUserName(userName);
        if (user == null) {
            return true;
        }
        return false;
    }
}
