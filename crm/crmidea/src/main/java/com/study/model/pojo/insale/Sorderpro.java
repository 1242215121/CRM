package com.study.model.pojo.insale;

import com.study.model.pojo.product.Product;

import javax.persistence.*;
import java.util.Objects;

/**
 * 销售订单和产品中间表
 */
public class Sorderpro {
    private Integer sorderproId;
    private Integer proNum; // 产品数量

    private Product product;//产品
    private Saleorder saleorder;//销售订单

    public Sorderpro() {
    }

    public Sorderpro(Integer sorderproId, Integer proNum) {
        this.sorderproId = sorderproId;
        this.proNum = proNum;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Saleorder getSaleorder() {
        return saleorder;
    }

    public void setSaleorder(Saleorder saleorder) {
        this.saleorder = saleorder;
    }

    @Override
    public String toString() {
        return "Sorderpro{" +
                "sorderproId=" + sorderproId +
                ", proNum=" + proNum +
                '}';
    }
}
