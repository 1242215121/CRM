package com.study.model.pojo.insale;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Salefunnel {

    private Integer sfId;
    private String sfName;
    private BigDecimal sfMoney;
    private Date sfDate;

    @Id
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
