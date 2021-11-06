package com.study.model.pojo.insale;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Sorderpro { // 销售订单和产品中间表
    private Integer sorderproId;
    private Integer proNum; // 产品数量
    private Integer soId; // 销售订单
    private String proId; // 产品编号

    public Sorderpro() {
    }

    public Sorderpro(Integer sorderproId, Integer proNum, Integer soId, String proId) {
        this.sorderproId = sorderproId;
        this.proNum = proNum;
        this.soId = soId;
        this.proId = proId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getSorderproId() {
        return sorderproId;
    }

    public void setSorderproId(Integer sorderproId) {
        this.sorderproId = sorderproId;
    }

    public Integer getProNum() {
        return proNum;
    }

    public void setProNum(Integer proNum) {
        this.proNum = proNum;
    }

    public Integer getSoId() {
        return soId;
    }

    public void setSoId(Integer soId) {
        this.soId = soId;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    @Override
    public String toString() {
        return "Sorderpro{" +
                "sorderproId=" + sorderproId +
                ", proNum=" + proNum +
                ", soId=" + soId +
                ", proId='" + proId + '\'' +
                '}';
    }
}
