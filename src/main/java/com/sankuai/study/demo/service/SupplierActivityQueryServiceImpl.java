package com.sankuai.study.demo.service;


import com.sankuai.study.demo.entities.SupplierActivity;
import com.sankuai.study.demo.mapper.SupplierActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SupplierActivityQueryServiceImpl implements SupplierActivityQueryService{

    @Autowired
    private SupplierActivityMapper supplierActivityDao;

    @Override
    public List<SupplierActivity> selectById(Long id){
        return supplierActivityDao.selectById(id);
    }

    @Override
    public List<SupplierActivity> fuzzSelectBySupplierName(String supplierName){
        String supplierNameConcat = "%" + supplierName + "%";
        return supplierActivityDao.fuzzSelectBySupplierName(supplierNameConcat);
    }

    @Override
    public int updateSignUpStatus(Long supplierId, Long activityId, Integer oldStatus, Integer newStatus){
        return supplierActivityDao.updateSignUpStatus(supplierId,activityId,oldStatus,newStatus);

    }

    @Override
    public int insertSupplierActivityInfo(Long id, Long activityId, String activityName, Long supplierId, String supplierName){
        return supplierActivityDao.insertSupplierActivityInfo(id, activityId, activityName,supplierId, supplierName);
    }

    @Override
    public int batchInsert(List<SupplierActivity> supplierActivityList){
        return supplierActivityDao.batchInsert(supplierActivityList);
    }

    @Override
    public int deleteById(Long id){
        return supplierActivityDao.deleteById(id);
    }

}
