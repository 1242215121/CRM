package com.study.model.pojo.product;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * 出入库单
 */
public class Bill {
    private String billId; //出入库单编号
    private Integer billAction; //库存动作
    private Integer billCount;//数量合计
    private String billWay;//发起方式
    private Integer billOrder;//关联单据
    private Integer billPerson;//发起人
    private Timestamp billCreateDate;//创建时间
    private Timestamp billManageDate;//办理时间
    private Integer billManagePerson;//办理人
    private Integer billState;//办理状态

    public Bill() {
        super();
    }

    public Bill(String billId, Integer billAction, Integer billCount, String billWay, Integer billOrder, Integer billPerson, Timestamp billCreateDate, Timestamp billManageDate, Integer billManagePerson, Integer billState) {
        this.billId = billId;
        this.billAction = billAction;
        this.billCount = billCount;
        this.billWay = billWay;
        this.billOrder = billOrder;
        this.billPerson = billPerson;
        this.billCreateDate = billCreateDate;
        this.billManageDate = billManageDate;
        this.billManagePerson = billManagePerson;
        this.billState = billState;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public Integer getBillAction() {
        return billAction;
    }

    public void setBillAction(Integer billAction) {
        this.billAction = billAction;
    }

    public Integer getBillCount() {
        return billCount;
    }

    public void setBillCount(Integer billCount) {
        this.billCount = billCount;
    }

    public String getBillWay() {
        return billWay;
    }

    public void setBillWay(String billWay) {
        this.billWay = billWay;
    }

    public Integer getBillOrder() {
        return billOrder;
    }

    public void setBillOrder(Integer billOrder) {
        this.billOrder = billOrder;
    }

    public Integer getBillPerson() {
        return billPerson;
    }

    public void setBillPerson(Integer billPerson) {
        this.billPerson = billPerson;
    }

    public Timestamp getBillCreateDate() {
        return billCreateDate;
    }

    public void setBillCreateDate(Timestamp billCreateDate) {
        this.billCreateDate = billCreateDate;
    }

    public Timestamp getBillManageDate() {
        return billManageDate;
    }

    public void setBillManageDate(Timestamp billManageDate) {
        this.billManageDate = billManageDate;
    }

    public Integer getBillManagePerson() {
        return billManagePerson;
    }

    public void setBillManagePerson(Integer billManagePerson) {
        this.billManagePerson = billManagePerson;
    }

    public Integer getBillState() {
        return billState;
    }

    public void setBillState(Integer billState) {
        this.billState = billState;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billId='" + billId + '\'' +
                ", billAction=" + billAction +
                ", billCount=" + billCount +
                ", billWay='" + billWay + '\'' +
                ", billOrder=" + billOrder +
                ", billPerson=" + billPerson +
                ", billCreateDate=" + billCreateDate +
                ", billManageDate=" + billManageDate +
                ", billManagePerson=" + billManagePerson +
                ", billState=" + billState +
                '}';
    }
}
