package com.js.money.util;

import java.util.Date;
import java.util.Map;

public class SearchEntity {
    private Integer pageIndex;
    private Integer pageSize;
    private String searchValue;
    private Map<String, Object> searchOther; //其他的一些查询参数

    public SearchEntity(Integer pageIndex, Integer pageSize) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public Map<String, Object> getSearchOther() {
        return searchOther;
    }

    public void setSearchOther(Map<String, Object> searchOther) {
        this.searchOther = searchOther;
    }
}
