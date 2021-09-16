package com.sankuai.study.demo.mapper;

import com.sankuai.study.demo.entities.SupplierActivity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

@Mapper
public interface SupplierActivityMapper {

    @Results(id = "BaseResultMap",value = {
            @Result(column = "id", property = "id", id = true),
            @Result(column = "activity_id", property = "activityId"),
            @Result(column = "activity_name", property = "activityName"),
            @Result(column = "activity_sign_up_deadline", property = "activitySignUpDeadline"),
            @Result(column = "supplier_id", property = "supplierId"),
            @Result(column = "supplier_name", property = "supplierName"),
            @Result(column = "sign_up_status", property = "signUpStatus")
    })
//    @Select("SELECT id, activity_id, activity_name, supplier_id, supplier_name FROM supplier_activity where supplier_name LIKE #{supplierName}")
    @Select("SELECT id, activity_id, activity_name, supplier_id, supplier_name FROM supplier_activity where supplier_name LIKE CONCAT('%',#{supplierName},'%')")
    List<SupplierActivity> fuzzSelectBySupplierName(@Param("supplierName")String supplierName );

    @ResultMap("BaseResultMap")
    @Select("SELECT id, activity_id, activity_name, supplier_id, supplier_name FROM supplier_activity where id = #{id}")
    List<SupplierActivity> selectById(Long id);

    @Update("UPDATE supplier_activity SET sign_up_status = #{newStatus} WHERE supplier_id = #{supplierId} and activity_id = #{activityId} and sign_up_status = #{oldStatus} ")
    int updateSignUpStatus(@Param("supplierId")Long supplierId, @Param("activityId")Long activityId, Integer oldStatus, Integer newStatus);

    @Insert("INSERT INTO supplier_activity(id,activity_id,activity_name,supplier_id,supplier_name) VALUES(#{id},#{activityId},#{activityName},#{supplierId},#{supplierName})")
    int insertSupplierActivityInfo(@Param("id") Long id, @Param("activityId")Long activityId, @Param("activityName")String activityName, @Param("supplierId")Long supplierId, @Param("supplierName")String supplierName);

    @Insert({
            "<script>",
            "insert into supplier_activity(id,activity_id,activity_name,supplier_id,supplier_name) values",
            "<foreach collection = 'supplierActivityList' item = 'item' index = 'index' separator = ','>",
            "(#{item.id},#{item.activityId},#{item.activityName},#{item.supplierId},#{item.supplierName})",
            "</foreach>",
            "</script>"
    })
    int batchInsert(@Param("supplierActivityList") List<SupplierActivity> supplierActivityList);

    @Delete("DELETE FROM supplier_activity WHERE id = #{id}")
    int deleteById(@Param("id") Long id);


}