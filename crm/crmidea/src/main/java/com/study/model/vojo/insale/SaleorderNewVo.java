package com.study.model.vojo.insale;

import java.util.List;

/**
 * 销售订单新增VO类
 */
public class SaleorderNewVo {
    private String name; //订单名称
    private Integer custom;//客户
    private Integer person;//销售机会
    private Integer user;//负责人 == 当前登录人员
    private List<ProductVo> product;//添加产品

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCustom() {
        return custom;
    }

    public void setCustom(Integer custom) {
        this.custom = custom;
    }

    public Integer getPerson() {
        return person;
    }

    public void setPerson(Integer person) {
        this.person = person;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public List<ProductVo> getProduct() {
        return product;
    }

    public void setProduct(List<ProductVo> product) {
        this.product = product;
    }
}
