package com.kaolashopping.kaola.mapper;

import com.kaolashopping.kaola.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author ming.zhong
 * @date 2018/2/14 下午11:17
 */
@Mapper
public interface UserMapper {
    String USER_COLUMN = " (`userName`, `password`, `addDate`, " +
            "`updateDate`, `status`, `isDeleted`, `nickName`) ";

    @Select("select * from user where id = #{id}")
    User getUserById(int id);

    @Select("select * from user where userName = #{userName} and password = #{password}")
    User getUserByIntance(User user);

    @Insert("insert into user" + USER_COLUMN + "values (#{userName}, #{password}, " +
            "#{addDate}, #{updateDate}, #{status}, #{isDeleted}, #{nickName})")
    int addUser(User user);

    @Select("select * from user where userName = #{userName} and status='1' and isDeleted='0'")
    User getUserByUserName(String userName);
}
