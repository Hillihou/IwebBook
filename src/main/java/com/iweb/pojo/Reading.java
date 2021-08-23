package com.iweb.pojo;


public class Reading {

  private Integer userId;
  private Integer fictionId;
  private String startTime;

  public Reading() {
  }

  public Reading(Integer userId, Integer fictionId, String startTime) {
    this.userId = userId;
    this.fictionId = fictionId;
    this.startTime = startTime;
  }

  @Override
  public String toString() {
    return "Reading{" +
            "userId=" + userId +
            ", fictionId=" + fictionId +
            ", startTime='" + startTime + '\'' +
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


  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

}
