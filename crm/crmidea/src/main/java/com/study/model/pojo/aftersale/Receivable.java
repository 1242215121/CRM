package com.study.model.pojo.aftersale;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.study.model.pojo.insale.Saleorder;
import com.study.model.pojo.power.Users;
import com.study.model.pojo.presale.Client;
import com.study.model.pojo.product.Product;

import java.sql.Timestamp;

/**
 * 回款
 */
public class Receivable {

  private String receivableId;//回款编号
  private Saleorder receivableDdid;//关联订单
  private Users receivableJbr;//经办人
  private double receivablePrice;//回款金额
  @JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Shanghai")
  private Timestamp receivableDate;//回款日期
  private String receivableHkfs;//回款方式
  private String receivableBz;//备注
  private long receivableZt;//审核状态 1为已审核 2为已驳回 3为未审核
  private Periodoftime receivableQcid;//期次
  private Client receivableKhid;//关联客户
  private Users receivableShr;//审核人

  public String getReceivableId() {
    return receivableId;
  }

  public void setReceivableId(String receivableId) {
    this.receivableId = receivableId;
  }


  public Saleorder getReceivableDdid() {
    return receivableDdid;
  }

  public void setReceivableDdid(Saleorder receivableDdid) {
    this.receivableDdid = receivableDdid;
  }


  public Users getReceivableJbr() {
    return receivableJbr;
  }

  public void setReceivableJbr(Users receivableJbr) {
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


  public Periodoftime getReceivableQcid() {
    return receivableQcid;
  }

  public void setReceivableQcid(Periodoftime receivableQcid) {
    this.receivableQcid = receivableQcid;
  }

  public Client getReceivableKhid() {
    return receivableKhid;
  }

  public void setReceivableKhid(Client receivableKhid) {
    this.receivableKhid = receivableKhid;
  }

  public Users getReceivableShr() {
    return receivableShr;
  }

  public void setReceivableShr(Users receivableShr) {
    this.receivableShr = receivableShr;
  }
}
