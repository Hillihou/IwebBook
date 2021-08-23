package com.iweb.pojo;

public class Fiction {
//    fictionId
//    fictionName
//    author
//    pages
//    createTime
//    descriptions
//    isMember（是否会员书籍）
//    isputaway(是否上架)
//    putawayTime（上架时间）
//    fictionimg(小说的封面图片)

    private Integer fictionId;
    private String fictionName;
    private String author;
    private Integer pages;
    private String createTime;
    private String descriptions;
    private String isMember;
    private String isputaway;
    private String putawayTime;
    private String fictionimg;

    public Fiction() {
    }

    public Fiction(Integer fictionId, String fictionName, String author, Integer pages, String createTime, String descriptions, String isMember, String isputaway, String putawayTime, String fictionimg) {
        this.fictionId = fictionId;
        this.fictionName = fictionName;
        this.author = author;
        this.pages = pages;
        this.createTime = createTime;
        this.descriptions = descriptions;
        this.isMember = isMember;
        this.isputaway = isputaway;
        this.putawayTime = putawayTime;
        this.fictionimg = fictionimg;
    }

    @Override
    public String toString() {
        return "Fiction{" +
                "fictionId=" + fictionId +
                ", fictionName='" + fictionName + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", createTime='" + createTime + '\'' +
                ", descriptions='" + descriptions + '\'' +
                ", isMember='" + isMember + '\'' +
                ", isputaway='" + isputaway + '\'' +
                ", putawayTime='" + putawayTime + '\'' +
                ", fictionimg='" + fictionimg + '\'' +
                '}';
    }

    public Integer getFictionId() {
        return fictionId;
    }

    public void setFictionId(Integer fictionId) {
        this.fictionId = fictionId;
    }

    public String getFictionName() {
        return fictionName;
    }

    public void setFictionName(String fictionName) {
        this.fictionName = fictionName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getIsMember() {
        return isMember;
    }

    public void setIsMember(String isMember) {
        this.isMember = isMember;
    }

    public String getIsputaway() {
        return isputaway;
    }

    public void setIsputaway(String isputaway) {
        this.isputaway = isputaway;
    }

    public String getPutawayTime() {
        return putawayTime;
    }

    public void setPutawayTime(String putawayTime) {
        this.putawayTime = putawayTime;
    }

    public String getFictionimg() {
        return fictionimg;
    }

    public void setFictionimg(String fictionimg) {
        this.fictionimg = fictionimg;
    }
}
