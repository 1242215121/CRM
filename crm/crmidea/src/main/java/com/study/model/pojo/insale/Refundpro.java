package com.study.model.pojo.insale;

import com.study.model.pojo.product.Product;

import javax.persistence.*;
import java.util.Objects;

/**
 * 退货单和产品的中间表
 */
public class Refundpro {
    private Integer refundproId;
    private Integer proNum; //退货产品数量

    private Product product;//产品
    private Refunds refunds;

    public Refundpro() {
    }

    public Refundpro(Integer refundproId, Integer proNum) {
        this.refundproId = refundproId;
        this.proNum = proNum;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Refunds getRefunds() {
        return refunds;
    }

    public void setRefunds(Refunds refunds) {
        this.refunds = refunds;
    }

    @Override
    public String toString() {
        return "Refundpro{" +
                "refundproId=" + refundproId +
                ", proNum=" + proNum +
                '}';
    }
}
