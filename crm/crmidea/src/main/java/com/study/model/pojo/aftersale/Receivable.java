package com.study.model.pojo.aftersale;


import java.sql.Timestamp;

/**
 * 回款
 */
public class Receivable {

  private String receivableId;//回款编号
  private long receivableDdid;//关联订单
  private long receivableJbr;//经办人
  private double receivablePrice;//回款金额
  private Timestamp receivableDate;//回款日期
  private String receivableHkfs;//回款方式
  private String receivableBz;//备注
  private long receivableZt;//审核状态
  private String receivableCpid;//产品编号
  private long receivableQcid;//期次


  public String getReceivableId() {
    return receivableId;
  }

  public void setReceivableId(String receivableId) {
    this.receivableId = receivableId;
  }


  public long getReceivableDdid() {
    return receivableDdid;
  }

  public void setReceivableDdid(long receivableDdid) {
    this.receivableDdid = receivableDdid;
  }


  public long getReceivableJbr() {
    return receivableJbr;
  }

  public void setReceivableJbr(long receivableJbr) {
    this.receivableJbr = receivableJbr;
  }


  public double getReceivablePrice() {
    return receivablePrice;
  }

  public void setReceivablePrice(double receivablePrice) {
    this.receivablePrice = receivablePrice;
  }


  public java.sql.Timestamp getReceivableDate() {
    return receivableDate;
  }

  public void setReceivableDate(java.sql.Timestamp receivableDate) {
    this.receivableDate = receivableDate;
  }


  public String getReceivableHkfs() {
    return receivableHkfs;
  }

  public void setReceivableHkfs(String receivableHkfs) {
    this.receivableHkfs = receivableHkfs;
  }


  public String getReceivableBz() {
    return receivableBz;
  }

  public void setReceivableBz(String receivableBz) {
    this.receivableBz = receivableBz;
  }


  public long getReceivableZt() {
    return receivableZt;
  }

  public void setReceivableZt(long receivableZt) {
    this.receivableZt = receivableZt;
  }


  public String getReceivableCpid() {
    return receivableCpid;
  }

  public void setReceivableCpid(String receivableCpid) {
    this.receivableCpid = receivableCpid;
  }


  public long getReceivableQcid() {
    return receivableQcid;
  }

  public void setReceivableQcid(long receivableQcid) {
    this.receivableQcid = receivableQcid;
  }

}
