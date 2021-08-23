package com.iweb.pojo;



public class Category {
    private Integer categoryId;
    private String categoryName;
    private String createTime;
    private String desc;

    public Category() {
    }

    public Category(Integer categoryId, String categoryName, String createTime, String desc) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.createTime = createTime;
        this.desc = desc;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", createTime=" + createTime +
                ", desc='" + desc + '\'' +
                '}';
    }
}
