package com.study.model.pojo.insale;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * 报价单
 */
public class Quotations {
    private Integer qId;
    private String qName;
    private BigDecimal qMoney; //报价金额
    private Date qDate;//报价日期
    private String qStage;//报价阶段
    private Timestamp qTime; //最后更新时间

    private Salefunnel salefunnelBySfId;//销售机会  一个报价单是由一个销售机会生成

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getqId() {
        return qId;
    }

    public void setqId(Integer qId) {
        this.qId = qId;
    }


    public String getqName() {
        return qName;
    }

    public void setqName(String qName) {
        this.qName = qName;
    }

    public BigDecimal getqMoney() {
        return qMoney;
    }

    public void setqMoney(BigDecimal qMoney) {
        this.qMoney = qMoney;
    }

    public Date getqDate() {
        return qDate;
    }

    public void setqDate(Date qDate) {
        this.qDate = qDate;
    }

    public String getqStage() {
        return qStage;
    }

    public void setqStage(String qStage) {
        this.qStage = qStage;
    }

    public Timestamp getqTime() {
        return qTime;
    }

    public void setqTime(Timestamp qTime) {
        this.qTime = qTime;
    }

    public Salefunnel getSalefunnelBySfId() {
        return salefunnelBySfId;
    }

    public void setSalefunnelBySfId(Salefunnel salefunnelBySfId) {
        this.salefunnelBySfId = salefunnelBySfId;
    }

    public Quotations() {
    }

    public Quotations(Integer qId, String qName, BigDecimal qMoney, Date qDate, String qStage, Timestamp qTime) {
        this.qId = qId;
        this.qName = qName;
        this.qMoney = qMoney;
        this.qDate = qDate;
        this.qStage = qStage;
        this.qTime = qTime;
    }

    @Override
    public String toString() {
        return "Quotations{" +
                "qId=" + qId +
                ", qName='" + qName + '\'' +
                ", qMoney=" + qMoney +
                ", qDate=" + qDate +
                ", qStage='" + qStage + '\'' +
                ", qTime=" + qTime +
                '}';
    }
}
