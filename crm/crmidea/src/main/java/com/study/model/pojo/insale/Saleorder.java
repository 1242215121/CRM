package com.study.model.pojo.insale;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Saleorder { // 销售订单
    private Integer soId; // 销售订单编号
    private String soName;  // 订单名称
    private BigDecimal soMoney;  // 订单金额
    private String soOrderstatu;    //  订单状态
    private BigDecimal soBack;      // 回款金额
    private BigDecimal soPay;    // 欠款金额
    private BigDecimal soReturn; // 退货单金额
    private String soBackstatu; // 回款状态
    private String soInvoicing; // 开票金额
    private BigDecimal soInvostatu; // 开票状态
    private Date soDate; //  成交日期
    private Integer soNum;  // 产品数量
    private Integer soWynum; // 已出库数量
    private Integer soNonum; // 未出库数量
    private String soWarestatu; // 出库状态

    private List<Refunds> refundsBySoId; // 一个订单可以生成多个退货单
    private Salefunnel salefunnelBySfId; // 一个销售订单源于一个销售机会

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getSoId() {
        return soId;
    }

    public void setSoId(Integer soId) {
        this.soId = soId;
    }

    public String getSoName() {
        return soName;
    }

    public void setSoName(String soName) {
        this.soName = soName;
    }

    public BigDecimal getSoMoney() {
        return soMoney;
    }

    public void setSoMoney(BigDecimal soMoney) {
        this.soMoney = soMoney;
    }

    public String getSoOrderstatu() {
        return soOrderstatu;
    }

    public void setSoOrderstatu(String soOrderstatu) {
        this.soOrderstatu = soOrderstatu;
    }

    public BigDecimal getSoBack() {
        return soBack;
    }

    public void setSoBack(BigDecimal soBack) {
        this.soBack = soBack;
    }

    public BigDecimal getSoPay() {
        return soPay;
    }

    public void setSoPay(BigDecimal soPay) {
        this.soPay = soPay;
    }

    public BigDecimal getSoReturn() {
        return soReturn;
    }

    public void setSoReturn(BigDecimal soReturn) {
        this.soReturn = soReturn;
    }

    public String getSoBackstatu() {
        return soBackstatu;
    }

    public void setSoBackstatu(String soBackstatu) {
        this.soBackstatu = soBackstatu;
    }

    public String getSoInvoicing() {
        return soInvoicing;
    }

    public void setSoInvoicing(String soInvoicing) {
        this.soInvoicing = soInvoicing;
    }

    public BigDecimal getSoInvostatu() {
        return soInvostatu;
    }

    public void setSoInvostatu(BigDecimal soInvostatu) {
        this.soInvostatu = soInvostatu;
    }

    public Date getSoDate() {
        return soDate;
    }

    public void setSoDate(Date soDate) {
        this.soDate = soDate;
    }

    public Integer getSoNum() {
        return soNum;
    }

    public void setSoNum(Integer soNum) {
        this.soNum = soNum;
    }

    public Integer getSoWynum() {
        return soWynum;
    }

    public void setSoWynum(Integer soWynum) {
        this.soWynum = soWynum;
    }

    public Integer getSoNonum() {
        return soNonum;
    }

    public void setSoNonum(Integer soNonum) {
        this.soNonum = soNonum;
    }

    public String getSoWarestatu() {
        return soWarestatu;
    }

    public void setSoWarestatu(String soWarestatu) {
        this.soWarestatu = soWarestatu;
    }

    public List<Refunds> getRefundsBySoId() {
        return refundsBySoId;
    }

    public void setRefundsBySoId(List<Refunds> refundsBySoId) {
        this.refundsBySoId = refundsBySoId;
    }

    public Salefunnel getSalefunnelBySfId() {
        return salefunnelBySfId;
    }

    public void setSalefunnelBySfId(Salefunnel salefunnelBySfId) {
        this.salefunnelBySfId = salefunnelBySfId;
    }

    public Saleorder() {
    }

    public Saleorder(Integer soId, String soName, BigDecimal soMoney, String soOrderstatu, BigDecimal soBack, BigDecimal soPay, BigDecimal soReturn, String soBackstatu, String soInvoicing, BigDecimal soInvostatu, Date soDate, Integer soNum, Integer soWynum, Integer soNonum, String soWarestatu) {
        this.soId = soId;
        this.soName = soName;
        this.soMoney = soMoney;
        this.soOrderstatu = soOrderstatu;
        this.soBack = soBack;
        this.soPay = soPay;
        this.soReturn = soReturn;
        this.soBackstatu = soBackstatu;
        this.soInvoicing = soInvoicing;
        this.soInvostatu = soInvostatu;
        this.soDate = soDate;
        this.soNum = soNum;
        this.soWynum = soWynum;
        this.soNonum = soNonum;
        this.soWarestatu = soWarestatu;
    }

    @Override
    public String toString() {
        return "Saleorder{" +
                "soId=" + soId +
                ", soName='" + soName + '\'' +
                ", soMoney=" + soMoney +
                ", soOrderstatu='" + soOrderstatu + '\'' +
                ", soBack=" + soBack +
                ", soPay=" + soPay +
                ", soReturn=" + soReturn +
                ", soBackstatu='" + soBackstatu + '\'' +
                ", soInvoicing='" + soInvoicing + '\'' +
                ", soInvostatu=" + soInvostatu +
                ", soDate=" + soDate +
                ", soNum=" + soNum +
                ", soWynum=" + soWynum +
                ", soNonum=" + soNonum +
                ", soWarestatu='" + soWarestatu + '\'' +
                '}';
    }
}
