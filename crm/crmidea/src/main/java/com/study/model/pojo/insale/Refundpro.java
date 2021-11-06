package com.study.model.pojo.insale;

import javax.persistence.*;
import java.util.Objects;


@Entity
public class Refundpro { //退货单和产品的中间表

    private Integer refundproId;
    private Integer proNum; //退货产品数量
    private Integer rId; // 退货单编号
    private String proId;

    public Refundpro() {
    }

    public Refundpro(Integer refundproId, Integer proNum, Integer rId, String proId) {
        this.refundproId = refundproId;
        this.proNum = proNum;
        this.rId = rId;
        this.proId = proId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getRefundproId() {
        return refundproId;
    }

    public void setRefundproId(Integer refundproId) {
        this.refundproId = refundproId;
    }

    public Integer getProNum() {
        return proNum;
    }

    public void setProNum(Integer proNum) {
        this.proNum = proNum;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    @Override
    public String toString() {
        return "Refundpro{" +
                "refundproId=" + refundproId +
                ", proNum=" + proNum +
                ", rId=" + rId +
                ", proId='" + proId + '\'' +
                '}';
    }
}
