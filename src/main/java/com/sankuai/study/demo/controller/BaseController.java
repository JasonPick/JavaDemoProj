package com.sankuai.study.demo.controller;

import com.sankuai.study.demo.common.Common;
import com.sankuai.study.demo.common.ResultVO;
import com.sankuai.study.demo.common.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
public class BaseController {

    public String getCurrentUserCode(){
        return null;
    }


    public void setCreateInfo(Common common){
        common.setCreateUser(getCurrentUserCode());
        common.setCreateDateTime(new Date());
        setModifyInfo(common);
    }

    public void setModifyInfo(Common common){
        common.setModifyUser(getCurrentUserCode());
        common.setModifyDateTime(new Date());
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResultVO exceptionHandler(Exception e){
        log.error(e.getMessage(),e);
        return ResultVO.fail("服务异常，无法连接到服务器，稍后重试");
    }

    @ResponseBody
    @ExceptionHandler(BusinessException.class)
    public ResultVO exceptionHandler(BusinessException e){
        log.error(e.getMessage(),e);
        return ResultVO.fail(e.getMessage());
    }
}
