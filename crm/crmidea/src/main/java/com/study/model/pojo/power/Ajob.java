package com.study.model.pojo.power;

import com.study.model.pojo.power.Users;

import java.util.List;

/**
 * 职位
 */
public class Ajob {
    private Integer ajobId;//编号
    private String ajobName;//职位名称
    private String ajobDesc;//职位描述
    private List<Users> users;

    @Override
    public String toString() {
        return "Ajob{" +
                "ajobId=" + ajobId +
                ", ajobName='" + ajobName + '\'' +
                ", ajobDesc='" + ajobDesc + '\'' +
                '}';
    }

    public Integer getAjobId() {
        return ajobId;
    }

    public void setAjobId(Integer ajobId) {
        this.ajobId = ajobId;
    }

    public String getAjobName() {
        return ajobName;
    }

    public void setAjobName(String ajobName) {
        this.ajobName = ajobName;
    }

    public String getAjobDesc() {
        return ajobDesc;
    }

    public void setAjobDesc(String ajobDesc) {
        this.ajobDesc = ajobDesc;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }
}
