package com.sankuai.study.demo.common.paging;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Condition {
    /**
     * 每页显示的数目
     * */
    private int numberPerPage = 20;
    /**
     * 当前在多少页
     * */
    private int pageNum = 1;
    /**
     * 排序的依据字段
     * */
    private String orderFeild;
    /**
     * 排序方法：逆序或是正序
     * */
    private String orderDirection = "desc";
}
