package com.study.model.pojo.product;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

public class ProductEntity {
    private String proId;  //产品编号
    private String proName; //产品名称
    private Integer proTypeId; //产品类别
    private Integer proState;  //产品状态
    private Integer proPerson; //产品负责人
    private String proUnit; //产品单位
    private Double proPrice; //产品基准价
    private Integer proInventoryState; //库存状态
    private Integer proInventoryAmount; //库存数量
    private Integer proInventoryUsable; //可用库存
    private Integer proInventoryLock;   //锁定库存
    private String proModel;   //产品型号
    private String proDescribe; //产品描述
    private Timestamp proDate;  //创建时间
    private String proBar;  //条形码

    public ProductEntity() {
        super();
    }

    public ProductEntity(String proId, String proName, Integer proTypeId, Integer proState, Integer proPerson, String proUnit, Double proPrice, Integer proInventoryState, Integer proInventoryAmount, Integer proInventoryUsable, Integer proInventoryLock, String proModel, String proDescribe, Timestamp proDate, String proBar) {
        this.proId = proId;
        this.proName = proName;
        this.proTypeId = proTypeId;
        this.proState = proState;
        this.proPerson = proPerson;
        this.proUnit = proUnit;
        this.proPrice = proPrice;
        this.proInventoryState = proInventoryState;
        this.proInventoryAmount = proInventoryAmount;
        this.proInventoryUsable = proInventoryUsable;
        this.proInventoryLock = proInventoryLock;
        this.proModel = proModel;
        this.proDescribe = proDescribe;
        this.proDate = proDate;
        this.proBar = proBar;
    }


    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public Integer getProTypeId() {
        return proTypeId;
    }

    public void setProTypeId(Integer proTypeId) {
        this.proTypeId = proTypeId;
    }

    public Integer getProState() {
        return proState;
    }

    public void setProState(Integer proState) {
        this.proState = proState;
    }

    public Integer getProPerson() {
        return proPerson;
    }

    public void setProPerson(Integer proPerson) {
        this.proPerson = proPerson;
    }

    public String getProUnit() {
        return proUnit;
    }

    public void setProUnit(String proUnit) {
        this.proUnit = proUnit;
    }

    public Double getProPrice() {
        return proPrice;
    }

    public void setProPrice(Double proPrice) {
        this.proPrice = proPrice;
    }

    public Integer getProInventoryState() {
        return proInventoryState;
    }

    public void setProInventoryState(Integer proInventoryState) {
        this.proInventoryState = proInventoryState;
    }

    public Integer getProInventoryAmount() {
        return proInventoryAmount;
    }

    public void setProInventoryAmount(Integer proInventoryAmount) {
        this.proInventoryAmount = proInventoryAmount;
    }

    public Integer getProInventoryUsable() {
        return proInventoryUsable;
    }

    public void setProInventoryUsable(Integer proInventoryUsable) {
        this.proInventoryUsable = proInventoryUsable;
    }

    public Integer getProInventoryLock() {
        return proInventoryLock;
    }

    public void setProInventoryLock(Integer proInventoryLock) {
        this.proInventoryLock = proInventoryLock;
    }

    public String getProModel() {
        return proModel;
    }

    public void setProModel(String proModel) {
        this.proModel = proModel;
    }

    public String getProDescribe() {
        return proDescribe;
    }

    public void setProDescribe(String proDescribe) {
        this.proDescribe = proDescribe;
    }

    public Timestamp getProDate() {
        return proDate;
    }

    public void setProDate(Timestamp proDate) {
        this.proDate = proDate;
    }

    public String getProBar() {
        return proBar;
    }

    public void setProBar(String proBar) {
        this.proBar = proBar;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "proId='" + proId + '\'' +
                ", proName='" + proName + '\'' +
                ", proTypeId=" + proTypeId +
                ", proState=" + proState +
                ", proPerson=" + proPerson +
                ", proUnit='" + proUnit + '\'' +
                ", proPrice=" + proPrice +
                ", proInventoryState=" + proInventoryState +
                ", proInventoryAmount=" + proInventoryAmount +
                ", proInventoryUsable=" + proInventoryUsable +
                ", proInventoryLock=" + proInventoryLock +
                ", proModel='" + proModel + '\'' +
                ", proDescribe='" + proDescribe + '\'' +
                ", proDate=" + proDate +
                ", proBar='" + proBar + '\'' +
                '}';
    }
}
