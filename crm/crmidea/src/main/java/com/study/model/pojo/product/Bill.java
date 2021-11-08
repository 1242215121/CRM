package com.study.model.pojo.product;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.study.model.pojo.power.Users;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
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
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private Timestamp billCreateDate;//创建时间
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private Timestamp billManageDate;//办理时间
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private Timestamp billLibraryDate;//出入库时间
    private Integer billManagePerson;//办理人
    private Integer billState;//办理状态
    private String billLibraryExplain;//出入库说明
    private String billManageExplain;//办理说明

    public Bill() {
        super();
    }

    public Bill(String billId, Integer billAction, Integer billCount, String billWay, Integer billOrder, Integer billPerson, Timestamp billCreateDate, Timestamp billManageDate, Timestamp billLibraryDate, Integer billManagePerson, Integer billState, String billLibraryExplain, String billManageExplain) {
        this.billId = billId;
        this.billAction = billAction;
        this.billCount = billCount;
        this.billWay = billWay;
        this.billOrder = billOrder;
        this.billPerson = billPerson;
        this.billCreateDate = billCreateDate;
        this.billManageDate = billManageDate;
        this.billLibraryDate = billLibraryDate;
        this.billManagePerson = billManagePerson;
        this.billState = billState;
        this.billLibraryExplain = billLibraryExplain;
        this.billManageExplain = billManageExplain;
    }

    public Users users;//负责人

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    //模糊查询
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    private List<Bills> bills;

    public List<Bills> getBills() {
        return bills;
    }

    public void setBills(List<Bills> bills) {
        this.bills = bills;
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

    public Timestamp getBillLibraryDate() {
        return billLibraryDate;
    }

    public void setBillLibraryDate(Timestamp billLibraryDate) {
        this.billLibraryDate = billLibraryDate;
    }

    public String getBillLibraryExplain() {
        return billLibraryExplain;
    }

    public void setBillLibraryExplain(String billLibraryExplain) {
        this.billLibraryExplain = billLibraryExplain;
    }

    public String getBillManageExplain() {
        return billManageExplain;
    }

    public void setBillManageExplain(String billManageExplain) {
        this.billManageExplain = billManageExplain;
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
                ", billLibraryDate=" + billLibraryDate +
                ", billManagePerson=" + billManagePerson +
                ", billState=" + billState +
                ", billLibraryExplain='" + billLibraryExplain + '\'' +
                ", billManageExplain='" + billManageExplain + '\'' +
                '}';
    }
}
