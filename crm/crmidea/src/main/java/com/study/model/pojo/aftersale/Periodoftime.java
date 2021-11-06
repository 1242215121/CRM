package com.study.model.pojo.aftersale;


/**
 * 期次
 */
public class Periodoftime {

  private long periodoftimeId;//期次编号
  private long periodoftimeDdid;//关联订单
  private String periodoftimeName;//期次名称
  private long periodoftimeFzr;//负责人
  private double periodoftimePrice;//计划回款金额
  private java.sql.Timestamp periodoftimeDate;//计划回款日期
  private String periodoftimeBz;//备注


  public long getPeriodoftimeId() {
    return periodoftimeId;
  }

  public void setPeriodoftimeId(long periodoftimeId) {
    this.periodoftimeId = periodoftimeId;
  }


  public long getPeriodoftimeDdid() {
    return periodoftimeDdid;
  }

  public void setPeriodoftimeDdid(long periodoftimeDdid) {
    this.periodoftimeDdid = periodoftimeDdid;
  }


  public String getPeriodoftimeName() {
    return periodoftimeName;
  }

  public void setPeriodoftimeName(String periodoftimeName) {
    this.periodoftimeName = periodoftimeName;
  }


  public long getPeriodoftimeFzr() {
    return periodoftimeFzr;
  }

  public void setPeriodoftimeFzr(long periodoftimeFzr) {
    this.periodoftimeFzr = periodoftimeFzr;
  }


  public double getPeriodoftimePrice() {
    return periodoftimePrice;
  }

  public void setPeriodoftimePrice(double periodoftimePrice) {
    this.periodoftimePrice = periodoftimePrice;
  }


  public java.sql.Timestamp getPeriodoftimeDate() {
    return periodoftimeDate;
  }

  public void setPeriodoftimeDate(java.sql.Timestamp periodoftimeDate) {
    this.periodoftimeDate = periodoftimeDate;
  }


  public String getPeriodoftimeBz() {
    return periodoftimeBz;
  }

  public void setPeriodoftimeBz(String periodoftimeBz) {
    this.periodoftimeBz = periodoftimeBz;
  }

}
