package com.study.model.pojo.insale;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Objects;


public class Salefunnel { //销售机会

    private Integer sfId;
    private String sfName;
    private BigDecimal sfMoney; //机会金额
    private Date sfDate; // 预计成交日

    private List<Quotations> quotationsBySfId;  // 一个销售机会可产生多个报价单
    private List<Saleorder> saleordersBySfId;  //一个销售机会可产生多个销售订单

    public Salefunnel() {
    }

    public Salefunnel(Integer sfId, String sfName, BigDecimal sfMoney, Date sfDate) {
        this.sfId = sfId;
        this.sfName = sfName;
        this.sfMoney = sfMoney;
        this.sfDate = sfDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getSfId() {
        return sfId;
    }

    public void setSfId(Integer sfId) {
        this.sfId = sfId;
    }

    public String getSfName() {
        return sfName;
    }

    public void setSfName(String sfName) {
        this.sfName = sfName;
    }

    public BigDecimal getSfMoney() {
        return sfMoney;
    }

    public void setSfMoney(BigDecimal sfMoney) {
        this.sfMoney = sfMoney;
    }

    public Date getSfDate() {
        return sfDate;
    }

    public void setSfDate(Date sfDate) {
        this.sfDate = sfDate;
    }


    public List<Quotations> getQuotationsBySfId() {
        return quotationsBySfId;
    }

    public void setQuotationsBySfId(List<Quotations> quotationsBySfId) {
        this.quotationsBySfId = quotationsBySfId;
    }


    public List<Saleorder> getSaleordersBySfId() {
        return saleordersBySfId;
    }

    public void setSaleordersBySfId(List<Saleorder> saleordersBySfId) {
        this.saleordersBySfId = saleordersBySfId;
    }

    @Override
    public String toString() {
        return "Salefunnel{" +
                "sfId=" + sfId +
                ", sfName='" + sfName + '\'' +
                ", sfMoney=" + sfMoney +
                ", sfDate=" + sfDate +
                '}';
    }

}
