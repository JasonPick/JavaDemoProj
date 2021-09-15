package com.sankuai.study.demo.common;

import lombok.*;

@Getter
@AllArgsConstructor
public enum ResultCode {
    /**
     *  success状态：成功，返回200
     *  fail状态：失败，返回500
     *  user_not_login：用户错误，返回2021
     * */

    SUCCESS(200,"success"),

    FAIL(500,"fail"),

    USER_NOT_LOGIN(2021,"User not login! Please check again!");

    private Integer code;

    private String message;



}
