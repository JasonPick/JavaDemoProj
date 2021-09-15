package com.sankuai.study.demo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sun.reflect.CallerSensitive;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Common {

    private String createUser;

    private Date createDateTime;

    private String modifyUser;

    private Date modifyDateTime;
}
