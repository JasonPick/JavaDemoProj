package com.sankuai.study.demo.mapper;

import com.sankuai.study.demo.entities.Activity;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author kunmasumoto
 */
public interface ActivityMapper {

    @Results(id = "yifei", value = {
            @Result(column = "id", property = "id", id = true)
    })
    @Select("select * from activity")
    List<Activity> listActivity();
}
