package com.sankuai.study.demo.controller;

import com.sankuai.study.demo.common.ResultVO;
import com.sankuai.study.demo.entities.SupplierActivity;
import com.sankuai.study.demo.service.SupplierActivityQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demo")
@Slf4j
public class SupplierActivityController {

    @Autowired
    private SupplierActivityQueryService supplierActivityQueryService;

    @GetMapping("/helloWorld")
    public ResultVO helloWorld(){
        return ResultVO.success("Hello SpringBoot Starter!");
    }

    @GetMapping(value = "/requestInfo/{username}")
    public ResultVO say(@PathVariable("username") String username) {
        return ResultVO.success(username);
    }

    @PostMapping(value = "/logInInfo")
    public ResultVO sayHi(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        return ResultVO.success(username + password);
    }

    @GetMapping(value = "/get/{id}")
    public ResultVO getSupplierActivities(@PathVariable("id") Long id) {
        return ResultVO.success(supplierActivityQueryService.selectById(id));
    }

    @RequestMapping(value = "/fuzzGet/{supplierName}")
    public ResultVO fuzzGetSupplierActivities(@PathVariable("supplierName") String supplierName) {
        return ResultVO.success(supplierActivityQueryService.fuzzSelectBySupplierName(supplierName));
    }

    @RequestMapping(value = "/update")
    public ResultVO updateSupplierActivities(@RequestParam(value = "supplierId") Long supplierId, @RequestParam(value = "activityId") Long activityId, @RequestParam(value = "oldStatus") Integer oldStatus ,@RequestParam(value = "newStatus") Integer newStatus){
        return ResultVO.success(supplierActivityQueryService.updateSignUpStatus(supplierId, activityId, oldStatus, newStatus));
    }

    @RequestMapping(value = "/insert")
    public ResultVO insertSupplierActivityInfo(@RequestParam(value = "id")Long id, @RequestParam(value = "activityId")Long activityId, @RequestParam(value = "activityName")String activityName, @RequestParam(value = "supplierId")Long supplierId, @RequestParam(value = "supplierName")String supplierName){
        return ResultVO.success(supplierActivityQueryService.insertSupplierActivityInfo(id, activityId, activityName, supplierId, supplierName));
    }

    @RequestMapping(value = "/delete")
    public ResultVO deleteById(@RequestParam("id")Long id){
        return ResultVO.success(supplierActivityQueryService.deleteById(id));
    }

    @PostMapping("/postList")
    public ResultVO postList(@RequestBody List<SupplierActivity> supplierActivityList){
        return ResultVO.success(supplierActivityQueryService.batchInsert(supplierActivityList));
    }

//    @GetMapping("/getList")
//    public ResultVO getList(@RequestParam("name") List<String> name){
//        return ResultVO.success(name);
//    }


}
