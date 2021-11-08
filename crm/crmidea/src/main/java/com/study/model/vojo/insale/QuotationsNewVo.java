package com.study.model.vojo.insale;

import java.util.List;

/**
 * 报价单新增Vo类
 */
public class QuotationsNewVo {
    private String name; //报价单名称
    private Integer activity;//关联机会
    private List<ProductVo> product;//添加产品

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getActivity() {
        return activity;
    }

    public void setActivity(Integer activity) {
        this.activity = activity;
    }

    public List<ProductVo> getProduct() {
        return product;
    }

    public void setProduct(List<ProductVo> product) {
        this.product = product;
    }
}
