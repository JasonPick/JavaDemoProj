package com.sankuai.study.demo.service;

import com.sankuai.study.demo.entities.SupplierActivity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupplierActivityQueryService {

    List<SupplierActivity> selectById(Long id);

    int updateSignUpStatus(Long supplierId, Long activityId, Integer oldStatus, Integer newStatus);

    int insertSupplierActivityInfo(Long id, Long activityId, String activityName, Long supplierId, String supplierName);

    int deleteById(Long id);
}
