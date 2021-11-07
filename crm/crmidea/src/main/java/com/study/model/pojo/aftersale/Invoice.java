package com.study.model.pojo.aftersale;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.study.model.pojo.insale.Saleorder;
import com.study.model.pojo.power.Users;
import com.study.model.pojo.presale.Client;

import java.sql.Timestamp;

/**
 * 开票记录表
 */
public class Invoice {

  private long invoiceId;//开票编号
  private Papertype invoicePjid;//票据类型
  private String invoiceName;//票据名称
  private Saleorder invoiceDdid;//关联订单
  private Periodoftime invoiceQcid;//期次
  private double invoicePrice;//开票金额
  private Users invoiceJbr;//经办人
  private String invoicePjtt;//票据抬头
  private String invoiceNssbh;//纳税识别号
  private String invoicePhone;//联系电话
  private String invoiceBz;//备注说明
  private long invoiceZt;//开票状态 1为已审核 2为已驳回 3为未审核
  private String invoiceKhyh;//开户银行
  private String invoiceKhzh;//开户账户
  private String invoiceKhdz;//开户地址
  private Client invoiceKhid;//关联客户
  private Users  invoiceShr;//审核人
  private String invoiceKphm;//开票号码
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")
  private Timestamp invoiceDate;//开票日期


  public long getInvoiceId() {
    return invoiceId;
  }

  public void setInvoiceId(long invoiceId) {
    this.invoiceId = invoiceId;
  }


  public Papertype getInvoicePjid() {
    return invoicePjid;
  }

  public void setInvoicePjid(Papertype invoicePjid) {
    this.invoicePjid = invoicePjid;
  }

  public String getInvoiceName() {
    return invoiceName;
  }

  public void setInvoiceName(String invoiceName) {
    this.invoiceName = invoiceName;
  }


  public Saleorder getInvoiceDdid() {
    return invoiceDdid;
  }

  public void setInvoiceDdid(Saleorder invoiceDdid) {
    this.invoiceDdid = invoiceDdid;
  }


  public Periodoftime getInvoiceQcid() {
    return invoiceQcid;
  }

  public void setInvoiceQcid(Periodoftime invoiceQcid) {
    this.invoiceQcid = invoiceQcid;
  }


  public double getInvoicePrice() {
    return invoicePrice;
  }

  public void setInvoicePrice(double invoicePrice) {
    this.invoicePrice = invoicePrice;
  }


  public Users getInvoiceJbr() {
    return invoiceJbr;
  }

  public void setInvoiceJbr(Users invoiceJbr) {
    this.invoiceJbr = invoiceJbr;
  }


  public String getInvoicePjtt() {
    return invoicePjtt;
  }

  public void setInvoicePjtt(String invoicePjtt) {
    this.invoicePjtt = invoicePjtt;
  }


  public String getInvoiceNssbh() {
    return invoiceNssbh;
  }

  public void setInvoiceNssbh(String invoiceNssbh) {
    this.invoiceNssbh = invoiceNssbh;
  }

  public String getInvoicePhone() {
    return invoicePhone;
  }

  public void setInvoicePhone(String invoicePhone) {
    this.invoicePhone = invoicePhone;
  }


  public String getInvoiceBz() {
    return invoiceBz;
  }

  public void setInvoiceBz(String invoiceBz) {
    this.invoiceBz = invoiceBz;
  }


  public long getInvoiceZt() {
    return invoiceZt;
  }

  public void setInvoiceZt(long invoiceZt) {
    this.invoiceZt = invoiceZt;
  }


  public String getInvoiceKhyh() {
    return invoiceKhyh;
  }

  public void setInvoiceKhyh(String invoiceKhyh) {
    this.invoiceKhyh = invoiceKhyh;
  }


  public String getInvoiceKhzh() {
    return invoiceKhzh;
  }

  public void setInvoiceKhzh(String invoiceKhzh) {
    this.invoiceKhzh = invoiceKhzh;
  }


  public String getInvoiceKhdz() {
    return invoiceKhdz;
  }

  public void setInvoiceKhdz(String invoiceKhdz) {
    this.invoiceKhdz = invoiceKhdz;
  }


  public Client getInvoiceKhid() {
    return invoiceKhid;
  }

  public void setInvoiceKhid(Client invoiceKhid) {
    this.invoiceKhid = invoiceKhid;
  }

  public String getInvoiceKphm() {
    return invoiceKphm;
  }

  public void setInvoiceKphm(String invoiceKphm) {
    this.invoiceKphm = invoiceKphm;
  }

  public Users getInvoiceShr() {
    return invoiceShr;
  }

  public void setInvoiceShr(Users invoiceShr) {
    this.invoiceShr = invoiceShr;
  }

  public Timestamp getInvoiceDate() {
    return invoiceDate;
  }

  public void setInvoiceDate(Timestamp invoiceDate) {
    this.invoiceDate = invoiceDate;
  }
}
