package com.study.model.vojo.insale;

public class ProductVo {
    private String proId;  //产品编号
    private String proName; //产品名称
    private Double proPrice; //产品基准价
    private Integer proInventoryAmount; //库存数量
    private Integer num;//购买数量

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public Double getProPrice() {
        return proPrice;
    }

    public void setProPrice(Double proPrice) {
        this.proPrice = proPrice;
    }

    public Integer getProInventoryAmount() {
        return proInventoryAmount;
    }

    public void setProInventoryAmount(Integer proInventoryAmount) {
        this.proInventoryAmount = proInventoryAmount;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "ProductVo{" +
                "proId='" + proId + '\'' +
                ", proName='" + proName + '\'' +
                ", proPrice=" + proPrice +
                ", proInventoryAmount=" + proInventoryAmount +
                ", num=" + num +
                '}';
    }
}
