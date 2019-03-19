package com.js.money.util;

import java.util.List;

public class SearchResult<Object> {
    private List<Object> rows; //查询到当前页面的信息
    private Integer totalPage; //所有页面
    private Long totalCount;  //所有数据

    public SearchResult(List<Object> rows, Integer totalPage, Long totalCount) {
        this.rows = rows;
        this.totalPage = totalPage;
        this.totalCount = totalCount;
    }

    public List<Object> getRows() {
        return rows;
    }

    public void setRows(List<Object> rows) {
        this.rows = rows;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }
}
