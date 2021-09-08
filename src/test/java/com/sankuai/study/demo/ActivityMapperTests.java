package com.sankuai.study.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.sankuai.study.demo.mapper.ActivityMapper;

@SpringBootTest
class ActivityMapperTests {

    @Autowired
    private ActivityMapper activityMapper;

    @Test
    void contextLoads() {
        activityMapper.listActivity();
    }

}
