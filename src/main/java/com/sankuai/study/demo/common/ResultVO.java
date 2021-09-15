package com.sankuai.study.demo.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultVO<T> {
    private Integer code;

    private String message;

    private T data;

    private ResultVO(Integer code, String message, T data ){
        this.code = code;
        this.message = message;
        this.data = data;

    }

    public static ResultVO success(){
        return success(null);
    }

    public static <T>ResultVO<T> success(T data){
        ResultVO resultVO = withCode(ResultCode.SUCCESS);
        resultVO.setData(data);
        return resultVO;
    }

    public static ResultVO fail(String message){
        ResultVO resultVO = withCode(ResultCode.FAIL);
        resultVO.setMessage(message);
        return resultVO;
    }

    public static ResultVO withCode(ResultCode resultCode){
        return withCode(resultCode,null);
    }

    public static <T>ResultVO<T> withCode(ResultCode resultCode, T data){
        return new ResultVO(resultCode.getCode(),resultCode.getMessage(),data);
    }
}
