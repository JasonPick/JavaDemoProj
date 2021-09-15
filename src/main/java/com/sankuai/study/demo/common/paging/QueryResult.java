package com.sankuai.study.demo.common.paging;

import lombok.*;

import java.util.List;

/**
 * @author kunmasumoto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryResult<T> {
    /**
     * 总条数
     * */
    private Long total;
    /**
     * 返回结果集
     * */
    private List<T> items;

}
