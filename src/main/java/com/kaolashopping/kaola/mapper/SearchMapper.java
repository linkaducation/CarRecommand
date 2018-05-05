package com.kaolashopping.kaola.mapper;

import com.kaolashopping.kaola.bean.HotCar;
import org.apache.ibatis.annotations.*;

@Mapper
public interface SearchMapper {

    @Select("select * from hotCar where userId = #{userId}")
    HotCar getHotCarByUser(@Param("userId") int userId);

    @Insert("insert into hotCar (`userId`, `carContent`, `brandContent`) values (#{userId}, #{carContent}, #{brandContent})")
    void insertHotCar(HotCar hotCar);

    @Update("update hotCar set carContent = #{carContent}, brandContent = #{brandContent} where userId = #{userId}")
    void updateHotCar(HotCar hotCar);
}
