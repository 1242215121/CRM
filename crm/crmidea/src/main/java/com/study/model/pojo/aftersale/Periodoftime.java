package com.study.model.pojo.aftersale;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.study.model.pojo.insale.Saleorder;
import com.study.model.pojo.power.Users;
import com.study.model.pojo.presale.Client;

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
  @JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Shanghai")
  private Timestamp periodoftimeDate;//计划回款日期
  private String periodoftimeBz;//备注
  private Client periodoftimeKhid;//关联客户
  private double periodoftimeSjprice;//实际回款金额
  private int periodoftimeQczt;//期次状态  1为已还款，2为部分还款，3为未还款
  private double periodoftimeKpprice;//开票金额


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


  public Timestamp getPeriodoftimeDate() {
    return periodoftimeDate;
  }

  public void setPeriodoftimeDate(Timestamp periodoftimeDate) {
    this.periodoftimeDate = periodoftimeDate;
  }


  public String getPeriodoftimeBz() {
    return periodoftimeBz;
  }

  public void setPeriodoftimeBz(String periodoftimeBz) {
    this.periodoftimeBz = periodoftimeBz;
  }

  public Client getPeriodoftimeKhid() {
    return periodoftimeKhid;
  }

  public void setPeriodoftimeKhid(Client periodoftimeKhid) {
    this.periodoftimeKhid = periodoftimeKhid;
  }

  public double getPeriodoftimeSjprice() {
    return periodoftimeSjprice;
  }

  public void setPeriodoftimeSjprice(double periodoftimeSjprice) {
    this.periodoftimeSjprice = periodoftimeSjprice;
  }

  public int getPeriodoftimeQczt() {
    return periodoftimeQczt;
  }

  public void setPeriodoftimeQczt(int periodoftimeQczt) {
    this.periodoftimeQczt = periodoftimeQczt;
  }

  public double getPeriodoftimeKpprice() {
    return periodoftimeKpprice;
  }

  public void setPeriodoftimeKpprice(double periodoftimeKpprice) {
    this.periodoftimeKpprice = periodoftimeKpprice;
  }
}
