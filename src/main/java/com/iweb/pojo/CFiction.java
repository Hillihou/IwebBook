package com.iweb.pojo;


public class CFiction {

  private Integer categoryId;
  private Integer fictionId;

  public CFiction() {
  }

  public CFiction(Integer categoryId, Integer fictionId) {
    this.categoryId = categoryId;
    this.fictionId = fictionId;
  }

  @Override
  public String toString() {
    return "CFiction{" +
            "categoryId=" + categoryId +
            ", fictionId=" + fictionId +
            '}';
  }

  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }


  public Integer getFictionId() {
    return fictionId;
  }

  public void setFictionId(Integer fictionId) {
    this.fictionId = fictionId;
  }

}
