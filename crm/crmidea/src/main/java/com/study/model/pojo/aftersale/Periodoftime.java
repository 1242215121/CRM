package com.study.model.pojo.aftersale;


import com.study.model.pojo.insale.Saleorder;
import com.study.model.pojo.power.Users;

import java.sql.Timestamp;

/**
 * 期次
 */
public class Periodoftime {

  private long periodoftimeId;//期次编号
  private Saleorder periodoftimeDdid;//关联订单
  private String periodoftimeName;//期次名称
  private Users periodoftimeFzr;//负责人
  private double periodoftimePrice;//计划回款金额
  private Timestamp periodoftimeDate;//计划回款日期
  private String periodoftimeBz;//备注


  public long getPeriodoftimeId() {
    return periodoftimeId;
  }

  public void setPeriodoftimeId(long periodoftimeId) {
    this.periodoftimeId = periodoftimeId;
  }


  public Saleorder getPeriodoftimeDdid() {
    return periodoftimeDdid;
  }

  public void setPeriodoftimeDdid(Saleorder periodoftimeDdid) {
    this.periodoftimeDdid = periodoftimeDdid;
  }


  public String getPeriodoftimeName() {
    return periodoftimeName;
  }

  public void setPeriodoftimeName(String periodoftimeName) {
    this.periodoftimeName = periodoftimeName;
  }


  public Users getPeriodoftimeFzr() {
    return periodoftimeFzr;
  }

  public void setPeriodoftimeFzr(Users periodoftimeFzr) {
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
