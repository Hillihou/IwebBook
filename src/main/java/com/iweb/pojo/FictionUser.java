package com.iweb.pojo;

public class FictionUser {
//    userId(用户ID)
//    userName
//    userPassword
//    userFullName（用户名称）
//    movephone（联系方式）
//    memberdayCount（会员剩余天数）
    private Integer userId;
    private String userName;
    private String userPassword;
    private String userFullName;
    private String movephone;
    private Integer memberdayCount;

    public FictionUser() {
    }

    public FictionUser(Integer userId, String userName, String userPassword, String userFullName, String movephone, Integer memberdayCount) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userFullName = userFullName;
        this.movephone = movephone;
        this.memberdayCount = memberdayCount;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getMovephone() {
        return movephone;
    }

    public void setMovephone(String movephone) {
        this.movephone = movephone;
    }

    public Integer getMemberdayCount() {
        return memberdayCount;
    }

    public void setMemberdayCount(Integer memberdayCount) {
        this.memberdayCount = memberdayCount;
    }

    @Override
    public String toString() {
        return "FictionUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userFullName='" + userFullName + '\'' +
                ", movephone='" + movephone + '\'' +
                ", memberdayCount=" + memberdayCount +
                '}';
    }
}
