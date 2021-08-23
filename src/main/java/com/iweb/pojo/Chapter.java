package com.iweb.pojo;


public class Chapter {

  private Integer chapterId;
  private String chapterName;
  private String chapterPath;
  private Integer fictionId;

  public Chapter() {
  }

  public Chapter(Integer chapterId, String chapterName, String chapterPath, Integer fictionId) {
    this.chapterId = chapterId;
    this.chapterName = chapterName;
    this.chapterPath = chapterPath;
    this.fictionId = fictionId;
  }

  @Override
  public String toString() {
    return "Chapter{" +
            "chapterId=" + chapterId +
            ", chapterName='" + chapterName + '\'' +
            ", chapterPath='" + chapterPath + '\'' +
            ", fictionId=" + fictionId +
            '}';
  }

  public Integer getChapterId() {
    return chapterId;
  }

  public void setChapterId(Integer chapterId) {
    this.chapterId = chapterId;
  }


  public String getChapterName() {
    return chapterName;
  }

  public void setChapterName(String chapterName) {
    this.chapterName = chapterName;
  }


  public String getChapterPath() {
    return chapterPath;
  }

  public void setChapterPath(String chapterPath) {
    this.chapterPath = chapterPath;
  }


  public Integer getFictionId() {
    return fictionId;
  }

  public void setFictionId(Integer fictionId) {
    this.fictionId = fictionId;
  }

}
