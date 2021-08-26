package com.iweb.util;

import java.util.List;

public class PageModel {
    //当前页数
    private int pageNo;
    //每页多少条
    private int pageSize=6;
    //总记录数
    private int recordCount;
    //总页数

    private int totalPages;

    private List<?> pageData;
    private String likeValue;

    public PageModel() {
    }

    public PageModel(int pageNo, int pageSize, int recordCount, int totalPages, List<?> pageData, String likeValue) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.recordCount = recordCount;
        this.totalPages = totalPages;
        this.pageData = pageData;
        this.likeValue = likeValue;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public int getTotalPages() {
        /**
         * 看是不是整除，是整除就是整数（整数是0就改成1，因为没有0页），不是整除就是整数+1
         */
        return recordCount%pageSize==0?((recordCount)==0?1:(recordCount/pageSize)):(recordCount/pageSize+1);
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<?> getPageData() {
        return pageData;
    }

    public void setPageData(List<?> pageData) {
        this.pageData = pageData;
    }

    public String getLikeValue() {
        return likeValue;
    }

    public void setLikeValue(String likeValue) {
        this.likeValue = likeValue;
    }
}
