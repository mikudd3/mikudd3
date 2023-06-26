package org.mikudd3.entity;

import lombok.Data;

import java.util.List;

/**
 * @project: 分页查询JavaBean
 * @author: mikudd3
 * @version: 1.0
 */
@Data
public class PageBean<T> {
    private int totalCount;

    private List<T> rows;

    public PageBean() {
    }

    public PageBean(int totalCount, List<T> rows) {
        this.totalCount = totalCount;
        this.rows = rows;
    }

}