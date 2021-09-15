package com.sankuai.study.demo.entities;


import lombok.Data;

import java.util.Date;

@Data
public class SupplierActivity {

    private Long id;

    private Long activityId;

    private String activityName;

    private Date activitySignUpDeadline;

    private Long supplierId;

    private String supplierName;

    private Integer signUpStatus;

}
