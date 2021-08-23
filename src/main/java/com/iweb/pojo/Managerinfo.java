package com.iweb.pojo;

public class Managerinfo {

  private Integer managerId;
  private String manageruserName;
  private String managerPassword;
  private String managerfullname;
  private String createTime;

  public Managerinfo() {
  }

  public Managerinfo(Integer managerId, String manageruserName, String managerPassword, String managerfullname, String createTime) {
    this.managerId = managerId;
    this.manageruserName = manageruserName;
    this.managerPassword = managerPassword;
    this.managerfullname = managerfullname;
    this.createTime = createTime;
  }

  @Override
  public String toString() {
    return "Managerinfo{" +
            "managerId=" + managerId +
            ", manageruserName='" + manageruserName + '\'' +
            ", managerPassword='" + managerPassword + '\'' +
            ", managerfullname='" + managerfullname + '\'' +
            ", createTime='" + createTime + '\'' +
            '}';
  }

  public Integer getManagerId() {
    return managerId;
  }

  public void setManagerId(Integer managerId) {
    this.managerId = managerId;
  }


  public String getManageruserName() {
    return manageruserName;
  }

  public void setManageruserName(String manageruserName) {
    this.manageruserName = manageruserName;
  }


  public String getManagerPassword() {
    return managerPassword;
  }

  public void setManagerPassword(String managerPassword) {
    this.managerPassword = managerPassword;
  }


  public String getManagerfullname() {
    return managerfullname;
  }

  public void setManagerfullname(String managerfullname) {
    this.managerfullname = managerfullname;
  }


  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

}
