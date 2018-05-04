package com.kaolashopping.kaola.mapper;

import com.kaolashopping.kaola.bean.BrandPopularity;
import com.kaolashopping.kaola.bean.Car;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BrandPopularityMapper {

    @Update("update brandPopularity set popularity = popularity + 1 where brand = #{brand}")
    void updateBrandPopularity(@Param("brand") String brand);

    @Select("select * from car where parentId = #{parentId} order by popularity desc limit 10")
    List<Car> getCarsByParentId(@Param("parentId") int parentId);

    @Select("select * from car where parentId = #{parentId} order by popularity desc")
    List<Car> getAllCarsByParentId(@Param("parentId") int parentId);

    @Select("select * from car where parentId = #{parentId} and id not in (${notIds}) order by popularity desc limit #{offset}")
    List<Car> getMoreCarsByParentId(@Param("parentId") int parentId, @Param("offset") int offset, @Param("notIds") String notIds);

    @Select("select * from brandPopularity where brand not in (${notBrand}) order by popularity desc limit #{offset}")
    List<BrandPopularity> getMoreBrand(@Param("notBrand") String notBrand, @Param("offset") int offset);

    @Select("select c1.* from car c1 inner join car c2 on c1.parentId = c2.id " +
            "inner join brandPopularity bp on c2.brand = bp.brand " +
            "where bp.brand = #{brand} order by c1.popularity desc limit 10")
    List<Car> getChildrenByBrand(@Param("brand") String brand);
}
