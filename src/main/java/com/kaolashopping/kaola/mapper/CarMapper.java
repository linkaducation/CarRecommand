package com.kaolashopping.kaola.mapper;

import com.kaolashopping.kaola.bean.BrandPopularity;
import com.kaolashopping.kaola.bean.Car;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * @author ming.zhong
 * @date 2018/3/11 上午8:30
 */
@Mapper
public interface CarMapper {

    /**
     * 根据厂商提取出热门的车辆展示在首页
     *
     * @param parentId
     * @param offset
     * @return
     */
    @Select("select * from car where parentId = #{parentId} and simIds is not null and minPrice is not null " +
            "order by popularity desc limit #{offset}")
    List<Car> getCarsByBrand(@Param("parentId") int parentId,
                             @Param("offset") int offset);

    @Select("select * from car where brand = #{brand}")
    Car getCarsByBrandNew(@Param("brand") String brand);

    /**
     * @return 获取以下热门厂商车辆
     */
    @Select("select car.* from brandPopularity bp inner join car on bp.brand = car.brand where car.parentId is null " +
            "and isChild = 0 order by bp.popularity desc limit 20")
    List<Car> getParentCars();

    @Select("select c1.* from car c1 inner join car c2 on c1.parentId = c2.id where c2.brand = #{brand} " +
            "and c1.simIds is not null order by popularity desc")
    List<Car> getCarsByBrandName(@Param("brand") String bran);

    /**
     * 根据父节点查询车辆信息
     *
     * @param pId
     * @return
     */
    @Select("select * from car where parentId = #{pId} and isChild = 1 order by brand")
    List<Car> getCarsByParentId(@Param("pId") int pId);

    /**
     * 根据ID查询车辆信息
     *
     * @param id
     * @return
     */
    @Select("select * from car where id = #{id}")
    Car getCarById(@Param("id") int id);

    @Select("select * from car where id in (${ids})")
    List<Car> getCarsByIds(@Param("ids") String ids);

    @Update("update cars set inventory = #{num} where id = #{pid}")
    void updateInventory(@Param("num") int num, @Param("pid") int id);

    @Select("select name from config where id in (${ids})")
    List<String> getConfigByIds(@Param("ids") String ids);

    @Select("select * from car_base_info where version = #{version} and series = #{series}")
    Map<String, String> getCarBySeriesAndVersion(@Param("version") String version, @Param("series") String series);

    @Select("select * from car where evaluate is not null and onSale = 1 and parentId is not null and isChild = 0")
    List<Car> getAllMidCar();

    @Update("update car set simIds = #{simIds}, otherSimIds = #{otherSimIds} where id = #{carId}")
    void updateSimCarById(@Param("carId") int carId, @Param("simIds") String simIds, @Param("otherSimIds") String otherIds);

    @Update("update car set popularity = popularity + 1 where id = #{id}")
    void updatePopularity(@Param("id") int pid);

    @Select("select c2.* from car c1 inner join car c2 on c1.parentId = c2.id where c1.id = #{id}")
    Car getParentByChildId(@Param("id") int id);
}
