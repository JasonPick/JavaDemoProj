package com.sankuai.study.demo.service;

import com.sankuai.study.demo.entities.SupplierActivity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupplierActivityQueryService {

    List<SupplierActivity> selectById(Long id);

    List<SupplierActivity> fuzzSelectBySupplierName(String supplierName);

    int updateSignUpStatus(Long supplierId, Long activityId, Integer oldStatus, Integer newStatus);

    int insertSupplierActivityInfo(Long id, Long activityId, String activityName, Long supplierId, String supplierName);

    int batchInsert(List<SupplierActivity> supplierActivityList);

    int deleteById(Long id);
}
