package com.study.model.pojo.insale;

import com.study.model.pojo.product.Product;

import javax.persistence.*;
import java.util.Objects;

/**
 * 报价单和产品的中间表
 */
public class Quotapro {
    private Integer quotaproId;
    private Integer proNum; //产品数量

    private Quotations quotations;// 报价单
    private Product product;//产品

    public Quotapro() {
    }

    public Quotapro(Integer quotaproId, Integer proNum) {
        this.quotaproId = quotaproId;
        this.proNum = proNum;
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

    public Quotations getQuotations() {
        return quotations;
    }

    public void setQuotations(Quotations quotations) {
        this.quotations = quotations;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Quotapro{" +
                "quotaproId=" + quotaproId +
                ", proNum=" + proNum +
                '}';
    }
}
