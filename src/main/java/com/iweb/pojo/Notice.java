package com.iweb.pojo;


public class Notice {

  private Integer noticeId;
  private String createTime;
  private String content;
  private Integer managerId;

  public Notice() {
  }

  public Notice(Integer noticeId, String createTime, String content, Integer managerId) {
    this.noticeId = noticeId;
    this.createTime = createTime;
    this.content = content;
    this.managerId = managerId;
  }

  @Override
  public String toString() {
    return "Notice{" +
            "noticeId=" + noticeId +
            ", createTime='" + createTime + '\'' +
            ", content='" + content + '\'' +
            ", managerId=" + managerId +
            '}';
  }

  public Integer getNoticeId() {
    return noticeId;
  }

  public void setNoticeId(Integer noticeId) {
    this.noticeId = noticeId;
  }


  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public Integer getManagerId() {
    return managerId;
  }

  public void setManagerId(Integer managerId) {
    this.managerId = managerId;
  }

}
