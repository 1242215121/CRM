package com.study.model.pojo.insale;

import com.study.model.pojo.power.Users;
import com.study.model.pojo.presale.Activity;
import com.study.model.pojo.presale.Client;
import com.study.model.pojo.presale.Contacts;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * 销售机会
 */
public class Salefunnel {
    private Integer sfId;
    private String sfName;
    private BigDecimal sfMoney; //机会金额
    private Date sfDate; // 预计成交日

    private List<Quotations> quotationsBySfId;  // 一个销售机会可产生多个报价单
    private List<Saleorder> saleordersBySfId;  //一个销售机会可产生多个销售订单

    private Users user;//一个销售机会一个负责人
    private Client client;//一个销售机会只有一个客户
    private Activity activity; // 一个销售机会关联一个活动
    private Contacts contacts;//一个销售机会关联一个联系人
    private List<Salepro> salepros;// 销售机会和产品中间表

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

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    public List<Salepro> getSalepros() {
        return salepros;
    }

    public void setSalepros(List<Salepro> salepros) {
        this.salepros = salepros;
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
