package com.study.model.pojo.aftersale;


/**
 * 票据类型
 */
public class Papertype {

  private long papertypeId;//票据类型编号
  private String papertypeName;//票据类型名称


  public long getPapertypeId() {
    return papertypeId;
  }

  public void setPapertypeId(long papertypeId) {
    this.papertypeId = papertypeId;
  }


  public String getPapertypeName() {
    return papertypeName;
  }

  public void setPapertypeName(String papertypeName) {
    this.papertypeName = papertypeName;
  }

}
