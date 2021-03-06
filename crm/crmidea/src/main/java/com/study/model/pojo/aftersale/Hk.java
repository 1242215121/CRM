package com.study.model.pojo.aftersale;



import com.study.model.pojo.product.Product;

/**
 * 回款详情
 */
public class Hk {

  private long hkId;//回款详情编号
  private String hkCpid;//回款产品编号
  private String hkCpname;//回款产品名称
  private double hkHkprice;//回款金额
  private long hkSl;//销售数量
  private double hkXszje;//销售总金额
  private double hkYhkprice;//已回款金额
  private double hkWhkprice;//未回款金额
  private String hkBz;//备注
  private String receivableId;//回款编号

  public long getHkId() {
    return hkId;
  }

  public void setHkId(long hkId) {
    this.hkId = hkId;
  }

  public String getHkCpid() {
    return hkCpid;
  }

  public void setHkCpid(String hkCpid) {
    this.hkCpid = hkCpid;
  }

  public String getHkCpname() {
    return hkCpname;
  }

  public void setHkCpname(String hkCpname) {
    this.hkCpname = hkCpname;
  }

  public double getHkHkprice() {
    return hkHkprice;
  }

  public void setHkHkprice(double hkHkprice) {
    this.hkHkprice = hkHkprice;
  }

  public long getHkSl() {
    return hkSl;
  }

  public void setHkSl(long hkSl) {
    this.hkSl = hkSl;
  }

  public double getHkXszje() {
    return hkXszje;
  }

  public void setHkXszje(double hkXszje) {
    this.hkXszje = hkXszje;
  }

  public double getHkYhkprice() {
    return hkYhkprice;
  }

  public void setHkYhkprice(double hkYhkprice) {
    this.hkYhkprice = hkYhkprice;
  }

  public double getHkWhkprice() {
    return hkWhkprice;
  }

  public void setHkWhkprice(double hkWhkprice) {
    this.hkWhkprice = hkWhkprice;
  }

  public String getHkBz() {
    return hkBz;
  }

  public void setHkBz(String hkBz) {
    this.hkBz = hkBz;
  }

  public String getReceivableId() {
    return receivableId;
  }

  public void setReceivableId(String receivableId) {
    this.receivableId = receivableId;
  }
}
