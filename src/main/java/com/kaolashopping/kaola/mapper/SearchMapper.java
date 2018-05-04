package com.kaolashopping.kaola.mapper;

import com.kaolashopping.kaola.bean.HotCar;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SearchMapper {

    @Select("select * from hotCar where id = #{userId}")
    HotCar getHotCarByUser(@Param("userId") int userId);

}
