package com.sankuai.study.demo.mapper;


import com.sankuai.study.demo.entities.SupplierActivity;
import com.sankuai.study.demo.mapper.SupplierActivityMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SupplierActivityMapperTests {

    @Resource
    private SupplierActivityMapper supplierActivityMapper;

    @Test
    void testSelectById(){
        List<SupplierActivity> supplierActivities = supplierActivityMapper.selectById(139L);
        System.out.println(supplierActivities);
    }

    @Test
    void testUpdateSignUpStatus(){
        supplierActivityMapper.updateSignUpStatus(139L,1180L,4,2);
        List<SupplierActivity> supplierActivities = supplierActivityMapper.selectById(139L);
        System.out.println(supplierActivities);
    }

    @Test
    void testInsertSupplierActivityInfo(){
        supplierActivityMapper.insertSupplierActivityInfo(178L,179L,"demo测试",67890L,"sankuaikeji");
        List<SupplierActivity> insertedSupplierActivities = supplierActivityMapper.selectById(178L);
        System.out.println(insertedSupplierActivities);

    }

    @Test
    void testDeleteById(){
        List<SupplierActivity> beforeDeleteSupplierActivities = supplierActivityMapper.selectById(178L);
        supplierActivityMapper.deleteById(178L);
        List<SupplierActivity> afterDeleteSupplierActivities = supplierActivityMapper.selectById(178L);
        System.out.println(beforeDeleteSupplierActivities);
        System.out.println(afterDeleteSupplierActivities);

    }
}
