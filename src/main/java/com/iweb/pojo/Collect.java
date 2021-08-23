package com.iweb.pojo;

public class Collect {
//    userId
//    fictionId
//    collectTime（收藏时间）
    private Integer userId;
    private Integer fictionId;
    private String collectTime;

    public Collect() {
    }

    public Collect(Integer userId, Integer fictionId, String collectTime) {
        this.userId = userId;
        this.fictionId = fictionId;
        this.collectTime = collectTime;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "userId=" + userId +
                ", fictionId=" + fictionId +
                ", collectTime='" + collectTime + '\'' +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFictionId() {
        return fictionId;
    }

    public void setFictionId(Integer fictionId) {
        this.fictionId = fictionId;
    }

    public String getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(String collectTime) {
        this.collectTime = collectTime;
    }
}
