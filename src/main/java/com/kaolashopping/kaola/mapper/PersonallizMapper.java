package com.kaolashopping.kaola.mapper;


import com.kaolashopping.kaola.bean.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

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

    @Select("select * from userCar where userId = #{userId} and type = #{type}")
    List<UserCar> getAllUserCar(@Param("userId") int userId, @Param("type") String type);

    @Select("select * from hotCarForBrowsing where userId = #{userId} and type = #{type}")
    HotCarForBrowsing getHotCarForBrowsing(@Param("userId") int userId, @Param("type") String type);

    @Insert("insert into hotCarForBrowsing (`userId`, `type`, `content`) values (#{userId}, #{type}, #{content})")
    void saveHotCarForBrowsing(HotCarForBrowsing hotCarForBrowsing);

    @Update("update hotCarForBrowsing set content = #{content} where userId = #{userId} and type = #{type}")
    void updateHotCarForBrowsing(HotCarForBrowsing hotCarForBrowsing);

    @Update("update carBrowsingHistory set deleted = 1 where userId = #{userId} and carId = #{carId}")
    void DeleteCarBrowsingHistory(@Param("userId") int userId, @Param("carId") int carId);

    @Update("update brandBrowsingHistory set deleted = 1 where userId = #{userId} and brand = #{brand}")
    void DeleteBrandBrowsingHistory(@Param("userId") int userId, @Param("brand") String brand);

    @Select("select * from carBrowsingHistory where userId = #{userId} and deleted = 0 " +
            "order by browsingDate desc limit 10")
    List<CarBrowsingHistory> getLatestCarBrowsing(@Param("userId") int userId);

    @Select("select count(*) as id, carId from carBrowsingHistory where userId = #{userId} group by carId order by id desc limit 10")
    List<CarBrowsingHistory> getMostViewCars(@Param("userId") int userId);

    @Select("select * from brandBrowsingHistory where userId = #{userId} and deleted = 0 order by browsingDate desc limit 5")
    List<BrandBrowsingHistory> getLatestBrands(@Param("userId") int userId);

    @Select("select count(*) as id, brand from brandBrowsingHistory where userId = #{userId} " +
            "group by brand order by id desc limit 5")
    List<BrandBrowsingHistory> getMostViewBrands(@Param("userId") int userId);
}
