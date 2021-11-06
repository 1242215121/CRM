package com.study.model.pojo.insale;

import javax.persistence.*;
import java.util.Objects;

/**
 * 销售机会和产品中间表
 */
public class Salepro {
    private Integer saleproId;
    private Integer proNum; // 产品数量
    private Integer sfId; // 销售机会编号
    private String proId; // 产品编号

    public Salepro() {
    }

    public Salepro(Integer saleproId, Integer proNum, Integer sfId, String proId) {
        this.saleproId = saleproId;
        this.proNum = proNum;
        this.sfId = sfId;
        this.proId = proId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getSaleproId() {
        return saleproId;
    }

    public void setSaleproId(Integer saleproId) {
        this.saleproId = saleproId;
    }

    public Integer getProNum() {
        return proNum;
    }

    public void setProNum(Integer proNum) {
        this.proNum = proNum;
    }

    public Integer getSfId() {
        return sfId;
    }

    public void setSfId(Integer sfId) {
        this.sfId = sfId;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    @Override
    public String toString() {
        return "Salepro{" +
                "saleproId=" + saleproId +
                ", proNum=" + proNum +
                ", sfId=" + sfId +
                ", proId='" + proId + '\'' +
                '}';
    }
}
