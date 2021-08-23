package com.iweb.pojo;


public class Payinfo {

  private Integer payId;
  private Integer userId;
  private String payTime;
  private String payMoney;
  private String addDays;

  public Payinfo() {
  }

  public Payinfo(Integer payId, Integer userId, String payTime, String payMoney, String addDays) {
    this.payId = payId;
    this.userId = userId;
    this.payTime = payTime;
    this.payMoney = payMoney;
    this.addDays = addDays;
  }

  @Override
  public String toString() {
    return "Payinfo{" +
            "payId=" + payId +
            ", userId=" + userId +
            ", payTime='" + payTime + '\'' +
            ", payMoney='" + payMoney + '\'' +
            ", addDays='" + addDays + '\'' +
            '}';
  }

  public Integer getPayId() {
    return payId;
  }

  public void setPayId(Integer payId) {
    this.payId = payId;
  }


  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }


  public String getPayTime() {
    return payTime;
  }

  public void setPayTime(String payTime) {
    this.payTime = payTime;
  }


  public String getPayMoney() {
    return payMoney;
  }

  public void setPayMoney(String payMoney) {
    this.payMoney = payMoney;
  }


  public String getAddDays() {
    return addDays;
  }

  public void setAddDays(String addDays) {
    this.addDays = addDays;
  }

}
