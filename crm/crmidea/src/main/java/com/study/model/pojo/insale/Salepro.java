package com.study.model.pojo.insale;

import com.study.model.pojo.product.Product;

import javax.persistence.*;
import java.util.Objects;

/**
 * 销售机会和产品中间表
 */
public class Salepro {
    private Integer saleproId;
    private Integer proNum; // 产品数量

    private Product product;//产品
    private Salefunnel salefunnel;//销售机会

    public Salepro() {
    }

    public Salepro(Integer saleproId, Integer proNum) {
        this.saleproId = saleproId;
        this.proNum = proNum;
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

    public Salefunnel getSalefunnel() {
        return salefunnel;
    }

    public void setSalefunnel(Salefunnel salefunnel) {
        this.salefunnel = salefunnel;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Salepro{" +
                "saleproId=" + saleproId +
                ", proNum=" + proNum +
                '}';
    }
}
