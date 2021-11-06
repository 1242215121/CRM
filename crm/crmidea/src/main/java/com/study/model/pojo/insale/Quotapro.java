package com.study.model.pojo.insale;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Quotapro {//报价单和产品的中间表
    private Integer quotaproId;
    private Integer proNum; //产品数量
    private Integer qId; // 报价单编号
    private String proId;


    public Quotapro() {
    }

    public Quotapro(Integer quotaproId, Integer proNum, Integer qId, String proId) {
        this.quotaproId = quotaproId;
        this.proNum = proNum;
        this.qId = qId;
        this.proId = proId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getQuotaproId() {
        return quotaproId;
    }

    public void setQuotaproId(Integer quotaproId) {
        this.quotaproId = quotaproId;
    }

    public Integer getProNum() {
        return proNum;
    }

    public void setProNum(Integer proNum) {
        this.proNum = proNum;
    }

    public Integer getqId() {
        return qId;
    }

    public void setqId(Integer qId) {
        this.qId = qId;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    @Override
    public String toString() {
        return "Quotapro{" +
                "quotaproId=" + quotaproId +
                ", proNum=" + proNum +
                ", qId=" + qId +
                ", proId='" + proId + '\'' +
                '}';
    }
}
