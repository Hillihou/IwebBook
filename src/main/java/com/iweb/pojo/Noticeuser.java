package com.iweb.pojo;

public class Noticeuser {

  private Integer noticeId;
  private Integer userId;

  public Noticeuser() {
  }

  @Override
  public String toString() {
    return "Noticeuser{" +
            "noticeId=" + noticeId +
            ", userId=" + userId +
            '}';
  }

  public Noticeuser(Integer noticeId, Integer userId) {
    this.noticeId = noticeId;
    this.userId = userId;
  }

  public Integer getNoticeId() {
    return noticeId;
  }

  public void setNoticeId(Integer noticeId) {
    this.noticeId = noticeId;
  }


  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

}
