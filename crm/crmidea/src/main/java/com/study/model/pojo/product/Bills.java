package com.study.model.pojo.product;

import javax.persistence.*;
import java.util.Objects;

/**
 * 出入库详单
 */
public class Bills {
    private int billsId;//出入库详单编号
    private String preId;//关联产品编号
    private String preName;//产品名称
    private String preUnit;//单位
    private Integer billsCount;//本次出库数量
    private String billsRemark;//备注
    private Integer billId;//关联出入库单

    public Bills() {
        super();
    }

    public Bills(int billsId, String preId, String preName, String preUnit, Integer billsCount, String billsRemark, Integer billId) {
        this.billsId = billsId;
        this.preId = preId;
        this.preName = preName;
        this.preUnit = preUnit;
        this.billsCount = billsCount;
        this.billsRemark = billsRemark;
        this.billId = billId;
    }

    public int getBillsId() {
        return billsId;
    }

    public void setBillsId(int billsId) {
        this.billsId = billsId;
    }

    public String getPreId() {
        return preId;
    }

    public void setPreId(String preId) {
        this.preId = preId;
    }

    public String getPreName() {
        return preName;
    }

    public void setPreName(String preName) {
        this.preName = preName;
    }

    public String getPreUnit() {
        return preUnit;
    }

    public void setPreUnit(String preUnit) {
        this.preUnit = preUnit;
    }

    public Integer getBillsCount() {
        return billsCount;
    }

    public void setBillsCount(Integer billsCount) {
        this.billsCount = billsCount;
    }

    public String getBillsRemark() {
        return billsRemark;
    }

    public void setBillsRemark(String billsRemark) {
        this.billsRemark = billsRemark;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    @Override
    public String toString() {
        return "Bills{" +
                "billsId=" + billsId +
                ", preId='" + preId + '\'' +
                ", preName='" + preName + '\'' +
                ", preUnit='" + preUnit + '\'' +
                ", billsCount=" + billsCount +
                ", billsRemark='" + billsRemark + '\'' +
                ", billId=" + billId +
                '}';
    }
}
