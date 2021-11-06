package com.study.model.pojo.presale;


import java.sql.Timestamp;

/**
 * 线索
 **/
public class Clue {

    private Integer clueId;//线索id
    private String clueName;//线索名称
    private Integer clueUser;//负责人外键
    private String clueCompany;//公司
    private String cluePost;//行业
    private String clueGoState;//跟进状态
    private String clueDuty;//职务
    private String clueState;//线索状态
    private Timestamp clueTime;//更新时间
    private String cluePhone;//联系电话

    public Integer getClueId() {
        return clueId;
    }

    public void setClueId(Integer clueId) {
        this.clueId = clueId;
    }

    public String getClueName() {
        return clueName;
    }

    public void setClueName(String clueName) {
        this.clueName = clueName;
    }


    public Integer getClueUser() {
        return clueUser;
    }

    public void setClueUser(Integer clueUser) {
        this.clueUser = clueUser;
    }


    public String getClueCompany() {
        return clueCompany;
    }

    public void setClueCompany(String clueCompany) {
        this.clueCompany = clueCompany;
    }


    public String getCluePost() {
        return cluePost;
    }

    public void setCluePost(String cluePost) {
        this.cluePost = cluePost;
    }


    public String getClueGoState() {
        return clueGoState;
    }

    public void setClueGoState(String clueGoState) {
        this.clueGoState = clueGoState;
    }


    public String getClueDuty() {
        return clueDuty;
    }

    public void setClueDuty(String clueDuty) {
        this.clueDuty = clueDuty;
    }


    public String getClueState() {
        return clueState;
    }

    public void setClueState(String clueState) {
        this.clueState = clueState;
    }


    public Timestamp getClueTime() {
        return clueTime;
    }

    public void setClueTime(Timestamp clueTime) {
        this.clueTime = clueTime;
    }


    public String getCluePhone() {
        return cluePhone;
    }

    public void setCluePhone(String cluePhone) {
        this.cluePhone = cluePhone;
    }


    public Clue() {
    }

    public Clue(Integer clueId, String clueName, String clueCompany, String cluePost, String clueGoState, String clueDuty, String clueState, Timestamp clueTime, String cluePhone) {
        this.clueId = clueId;
        this.clueName = clueName;
        this.clueCompany = clueCompany;
        this.cluePost = cluePost;
        this.clueGoState = clueGoState;
        this.clueDuty = clueDuty;
        this.clueState = clueState;
        this.clueTime = clueTime;
        this.cluePhone = cluePhone;
    }

    @Override
    public String toString() {
        return "Clue{" +
                "clueId=" + clueId +
                ", clueName='" + clueName + '\'' +
                ", clueUser=" + clueUser +
                ", clueCompany='" + clueCompany + '\'' +
                ", cluePost='" + cluePost + '\'' +
                ", clueGoState='" + clueGoState + '\'' +
                ", clueDuty='" + clueDuty + '\'' +
                ", clueState='" + clueState + '\'' +
                ", clueTime=" + clueTime +
                ", cluePhone='" + cluePhone + '\'' +
                '}';
    }
}
