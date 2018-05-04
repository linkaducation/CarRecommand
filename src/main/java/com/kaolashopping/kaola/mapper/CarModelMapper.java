package com.kaolashopping.kaola.mapper;

import com.kaolashopping.kaola.bean.CarModel;
import com.kaolashopping.kaola.bean.OveragePremiumRateOfCarUsingAge;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author ming.zhong
 * @date 2018/3/24 下午10:06
 */
@Mapper
public interface CarModelMapper {

    /**
     * 获取所有的汽车品牌
     * @return
     */
    @Select("select distinct(brand) from carModel where deleted is null")
    List<String> getDistinctCarModel();

    /**
     * 获取某个品牌车龄为carAge的所有车的信息
     * @param brand
     * @param carAge
     * @return
     */
    @Select("select * from carModel where brand = #{brand} and carAge = #{carAge}")
    List<CarModel> getCarByBrand(@Param("brand") String brand, @Param("carAge") int carAge);

    /**
     * 插入车辆对应的baozhilv
     * @param oprca
     * @return
     */
    @Insert("insert into overagePremiumRateOfCarUsingAge (`premiumRate`, `carAge`, `brand`, `sampleCount`) " +
            "values (#{premiumRate}, ${carAge}, #{brand}, #{sampleCount})")
    int saveModel(OveragePremiumRateOfCarUsingAge oprca);

    /**
     * 删除旧的数据
     * @param brand
     * @param carAge
     */
    @Delete("delete from carModel where brand = #{brand} and carAge = #{carAge}")
    void removeOldModel(@Param("brand") String brand, @Param("carAge") int carAge);

    /**
     * 根据brand获取该车辆的保值率
     * @param brand
     * @return
     */
    @Select("select * from overagePremiumRateOfCarUsingAge where brand = #{brand} order by carAge desc")
    List<OveragePremiumRateOfCarUsingAge> getDataByBrand(String brand);
}
