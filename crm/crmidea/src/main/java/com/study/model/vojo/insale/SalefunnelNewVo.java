package com.study.model.vojo.insale;

import com.study.model.pojo.product.Product;

import java.util.List;

/**
 * 销售机会新增的VO类
 */
public class SalefunnelNewVo {

    private String starttime;//预计成交日
    private String name; //机会名称
    private String money;//机会金额
    private Integer emp;//负责人员
    private Integer custom;//客户
    private Integer person;//联系人
    private Integer activity;//关联活动
    private List<ProductVo> product;//添加产品

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public Integer getEmp() {
        return emp;
    }

    public void setEmp(Integer emp) {
        this.emp = emp;
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
