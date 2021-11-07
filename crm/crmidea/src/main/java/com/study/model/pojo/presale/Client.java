package com.study.model.pojo.presale;


import com.study.model.pojo.insale.Salefunnel;

import java.util.List;

/**
 * 客户
 **/
public class Client {
    private Integer clientId;//客户id
    private String clientRule;//客户编码
    private String clientName;//客户名称
    private Integer clientUser;//负责人外键
    private String clientAddress;//地址
    private String clientPhone;//客户电话
    private String clientState;//跟进状态
    private String clientSource;//客户来源
    private String clientRank;//客户级别
    private String clientLinkman;//联系人
    private String clientScale;//客户规模

    private List<Salefunnel> salefunnels;//销售机会

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }


    public String getClientRule() {
        return clientRule;
    }

    public void setClientRule(String clientRule) {
        this.clientRule = clientRule;
    }


    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }


    public Integer getClientUser() {
        return clientUser;
    }

    public void setClientUser(Integer clientUser) {
        this.clientUser = clientUser;
    }


    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }


    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }


    public String getClientState() {
        return clientState;
    }

    public void setClientState(String clientState) {
        this.clientState = clientState;
    }


    public String getClientSource() {
        return clientSource;
    }

    public void setClientSource(String clientSource) {
        this.clientSource = clientSource;
    }


    public String getClientRank() {
        return clientRank;
    }

    public void setClientRank(String clientRank) {
        this.clientRank = clientRank;
    }


    public String getClientLinkman() {
        return clientLinkman;
    }

    public void setClientLinkman(String clientLinkman) {
        this.clientLinkman = clientLinkman;
    }


    public String getClientScale() {
        return clientScale;
    }

    public void setClientScale(String clientScale) {
        this.clientScale = clientScale;
    }

    public List<Salefunnel> getSalefunnels() {
        return salefunnels;
    }

    public void setSalefunnels(List<Salefunnel> salefunnels) {
        this.salefunnels = salefunnels;
    }

    public Client() {
    }


    public Client(Integer clientId, String clientRule, String clientName, String clientAddress, String clientPhone, String clientState, String clientSource, String clientRank, String clientLinkman, String clientScale) {

        this.clientId = clientId;
        this.clientRule = clientRule;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.clientPhone = clientPhone;
        this.clientState = clientState;
        this.clientSource = clientSource;
        this.clientRank = clientRank;
        this.clientLinkman = clientLinkman;
        this.clientScale = clientScale;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", clientRule='" + clientRule + '\'' +
                ", clientName='" + clientName + '\'' +
                ", clientUser=" + clientUser +
                ", clientAddress='" + clientAddress + '\'' +
                ", clientPhone='" + clientPhone + '\'' +
                ", clientState='" + clientState + '\'' +
                ", clientSource='" + clientSource + '\'' +
                ", clientRank='" + clientRank + '\'' +
                ", clientLinkman='" + clientLinkman + '\'' +
                ", clientScale='" + clientScale + '\'' +
                '}';
    }
}
