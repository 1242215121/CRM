package com.study.model.pojo.aftersale;


/**
 * 开票记录表
 */
public class Invoice {

  private long invoiceId;//开票编号
  private Papertype invoicePjid;//票据类型
  private String invoiceName;//票据名称
  private long invoiceDdid;//关联订单
  private long invoiceQcid;//期次
  private double invoicePrice;//开票金额
  private long invoiceJbr;//经办人
  private String invoicePjtt;//票据抬头
  private String invoiceNssbh;//纳税识别号
  private long invoicePjyjzt;//票价邮件是否需要邮件的状态 0代表不需要 1代表需要
  private String invoiceSjr;//收件人
  private String invoicePhone;//联系电话
  private String invoiceBz;//备注说明
  private long invoiceZt;//开票状态 0代表待办理，1代表已办理，2代表审批中，3代表被驳回
  private String invoiceKhyh;//开户银行
  private String invoiceKhzh;//开户账户
  private String invoiceKhdz;//开户地址
  private long invoiceKhid;//关联客户


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


  public long getInvoiceDdid() {
    return invoiceDdid;
  }

  public void setInvoiceDdid(long invoiceDdid) {
    this.invoiceDdid = invoiceDdid;
  }


  public long getInvoiceQcid() {
    return invoiceQcid;
  }

  public void setInvoiceQcid(long invoiceQcid) {
    this.invoiceQcid = invoiceQcid;
  }


  public double getInvoicePrice() {
    return invoicePrice;
  }

  public void setInvoicePrice(double invoicePrice) {
    this.invoicePrice = invoicePrice;
  }


  public long getInvoiceJbr() {
    return invoiceJbr;
  }

  public void setInvoiceJbr(long invoiceJbr) {
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


  public long getInvoicePjyjzt() {
    return invoicePjyjzt;
  }

  public void setInvoicePjyjzt(long invoicePjyjzt) {
    this.invoicePjyjzt = invoicePjyjzt;
  }


  public String getInvoiceSjr() {
    return invoiceSjr;
  }

  public void setInvoiceSjr(String invoiceSjr) {
    this.invoiceSjr = invoiceSjr;
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


  public long getInvoiceKhid() {
    return invoiceKhid;
  }

  public void setInvoiceKhid(long invoiceKhid) {
    this.invoiceKhid = invoiceKhid;
  }

}
