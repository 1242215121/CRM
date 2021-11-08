package com.study.model.pojo.insale;

import com.study.model.pojo.power.Users;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

/**
 * 退货单
 */
public class Refunds {
    private Integer rId;
    private String rName;
    private BigDecimal rMoney; // 退货金额
    private Date rDate; // 退货日期
    private String rWay; // 退货方式
    private String rReasons; // 退货原因
    private String rTel; // 联系电话
    private Integer rNum; // 退货产品数量
    private String rStatu;//入库状态

    private Saleorder saleorderBySoId; // 销售订单  一个退货单源于一个销售订单
    private Users users;//负责人
    private List<Refundpro> refundpros;

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

    public String getrStatu() {
        return rStatu;
    }

    public void setrStatu(String rStatu) {
        this.rStatu = rStatu;
    }

    public Saleorder getSaleorderBySoId() {
        return saleorderBySoId;
    }

    public void setSaleorderBySoId(Saleorder saleorderBySoId) {
        this.saleorderBySoId = saleorderBySoId;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public List<Refundpro> getRefundpros() {
        return refundpros;
    }

    public void setRefundpros(List<Refundpro> refundpros) {
        this.refundpros = refundpros;
    }

    public Refunds() {

    }

    public Refunds(Integer rId, String rName, BigDecimal rMoney, Date rDate, String rWay, String rReasons, String rTel, Integer rNum, String rStatu) {
        this.rId = rId;
        this.rName = rName;
        this.rMoney = rMoney;
        this.rDate = rDate;
        this.rWay = rWay;
        this.rReasons = rReasons;
        this.rTel = rTel;
        this.rNum = rNum;
        this.rStatu = rStatu;
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
                ", rStatu=" + rStatu +
                '}';
    }
}
