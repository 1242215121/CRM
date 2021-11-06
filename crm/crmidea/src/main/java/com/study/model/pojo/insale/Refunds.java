package com.study.model.pojo.insale;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

public class Refunds { // 退货单
    private Integer rId;
    private String rName;
    private BigDecimal rMoney; // 退货金额
    private Date rDate; // 退货日期
    private String rWay; // 退货方式
    private String rReasons; // 退货原因
    private String rTel; // 联系电话
    private Integer rNum; // 退货产品数量

    private Saleorder saleorderBySoId; // 销售订单  一个退货单源于一个销售订单

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public BigDecimal getrMoney() {
        return rMoney;
    }

    public void setrMoney(BigDecimal rMoney) {
        this.rMoney = rMoney;
    }

    public Date getrDate() {
        return rDate;
    }

    public void setrDate(Date rDate) {
        this.rDate = rDate;
    }

    public String getrWay() {
        return rWay;
    }

    public void setrWay(String rWay) {
        this.rWay = rWay;
    }

    public String getrReasons() {
        return rReasons;
    }

    public void setrReasons(String rReasons) {
        this.rReasons = rReasons;
    }

    public String getrTel() {
        return rTel;
    }

    public void setrTel(String rTel) {
        this.rTel = rTel;
    }

    public Integer getrNum() {
        return rNum;
    }

    public void setrNum(Integer rNum) {
        this.rNum = rNum;
    }

    public Saleorder getSaleorderBySoId() {
        return saleorderBySoId;
    }

    public void setSaleorderBySoId(Saleorder saleorderBySoId) {
        this.saleorderBySoId = saleorderBySoId;
    }

    public Refunds() {

    }

    public Refunds(Integer rId, String rName, BigDecimal rMoney, Date rDate, String rWay, String rReasons, String rTel, Integer rNum) {
        this.rId = rId;
        this.rName = rName;
        this.rMoney = rMoney;
        this.rDate = rDate;
        this.rWay = rWay;
        this.rReasons = rReasons;
        this.rTel = rTel;
        this.rNum = rNum;
    }

    @Override
    public String toString() {
        return "Refunds{" +
                "rId=" + rId +
                ", rName='" + rName + '\'' +
                ", rMoney=" + rMoney +
                ", rDate=" + rDate +
                ", rWay='" + rWay + '\'' +
                ", rReasons='" + rReasons + '\'' +
                ", rTel='" + rTel + '\'' +
                ", rNum=" + rNum +
                '}';
    }
}
