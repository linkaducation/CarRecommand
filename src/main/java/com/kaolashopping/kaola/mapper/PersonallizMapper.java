package com.kaolashopping.kaola.mapper;


import com.kaolashopping.kaola.bean.*;
import org.apache.ibatis.annotations.*;

@Mapper
public interface PersonallizMapper {

    @Select("select * from touristUser where touristKey = #{touristKey}")
    TouristUser getTouristUserByTouristKey(@Param("touristKey") String touristKey);

    @Select("select * from userBrand where userId = #{userId} and type = #{type}")
    UserBrand getUserBrand(@Param("userId") int userId, @Param("type") String type);

    @Insert("insert into userBrand (`userId`, `type`, `content`) values (#{userId}, #{type}, #{content})")
    void addUserBrand(UserBrand userBrand);

    @Update("update userBrand set content = #{content} where id = #{id}")
    void updateUserBrand(UserBrand userBrand);

    @Select("select * from userCar where userId = #{userId} and type = #{type} and brandId = #{brandId}")
    UserCar getUserCar(@Param("userId") int userId, @Param("type") String type, @Param("brandId") int brandId);

    @Insert("insert into userCar (`userId`, `type`, `content`, `brandId`) values (#{userId}, #{type}, #{content}, #{brandId})")
    void addUserCar(UserCar userCar);

    @Update("update userCar set content = #{content} where id = #{id}")
    void updateUserCar(UserCar userCar);

    @Insert("insert into touristUser (`touristKey`) values (#{touristKey})")
    void addTouristUser(TouristUser touristUser);

    @Insert("insert into brandBrowsingHistory (`userId`, `brandId`, `brand`, `browsingDate`) " +
            "values (#{userId}, #{brandId}, #{brand}, #{browsingDate})")
    void saveBrandBrowsingHistory(BrandBrowsingHistory bbh);

    @Insert("insert into carBrowsingHistory (`userId`, `carId`, `browsingDate`) " +
            "values (#{userId}, #{carId}, #{browsingDate})")
    void saveCarBrowsingHistory(CarBrowsingHistory cbh);
}
