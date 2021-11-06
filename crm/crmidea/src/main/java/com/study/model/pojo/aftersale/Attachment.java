package com.study.model.pojo.aftersale;


/**
 * 附件资料
 */
public class Attachment {

  private long attachmentId;//附件编号
  private String attachmentSrc;//附件路径
  private String attachmentHkid;//回款编号


  public long getAttachmentId() {
    return attachmentId;
  }

  public void setAttachmentId(long attachmentId) {
    this.attachmentId = attachmentId;
  }


  public String getAttachmentSrc() {
    return attachmentSrc;
  }

  public void setAttachmentSrc(String attachmentSrc) {
    this.attachmentSrc = attachmentSrc;
  }


  public String getAttachmentHkid() {
    return attachmentHkid;
  }

  public void setAttachmentHkid(String attachmentHkid) {
    this.attachmentHkid = attachmentHkid;
  }

  @Override
  public String toString() {
    return "Attachment{" +
            "attachmentId=" + attachmentId +
            ", attachmentSrc='" + attachmentSrc + '\'' +
            ", attachmentHkid='" + attachmentHkid + '\'' +
            '}';
  }
}
