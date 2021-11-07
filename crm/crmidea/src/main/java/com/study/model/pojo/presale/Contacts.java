package com.study.model.pojo.presale;


import com.study.model.pojo.insale.Salefunnel;
import com.study.model.pojo.power.Users;

import java.util.List;

/**
 * 联系人
 **/
public class Contacts {
    private Integer contactsId;//联系人id
    private String contactsName;//姓名
    private String contactsDuty;//职务
    private String contactsPhone;//联系人电话
    private String contactsRole;//角色
    private String contactsCase;//在职情况
    private Integer contactsCutostomer;//客户外键
    private Integer pageNo;
    private Integer size;
    private Users users;

    public String getContactsName() {
        return contactsName;
    }

    public void setContactsName(String contactsName) {
        this.contactsName = contactsName;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    private List<Salefunnel> salefunnels;//销售机会


    public Integer getContactsId() {
        return contactsId;
    }

    public void setContactsId(Integer contactsId) {
        this.contactsId = contactsId;
    }



    public String getContactsDuty() {
        return contactsDuty;
    }

    public void setContactsDuty(String contactsDuty) {
        this.contactsDuty = contactsDuty;
    }


    public String getContactsPhone() {
        return contactsPhone;
    }

    public void setContactsPhone(String contactsPhone) {
        this.contactsPhone = contactsPhone;
    }


    public String getContactsRole() {
        return contactsRole;
    }

    public void setContactsRole(String contactsRole) {
        this.contactsRole = contactsRole;
    }

    public String getContactsCase() {
        return contactsCase;
    }

    public void setContactsCase(String contactsCase) {
        this.contactsCase = contactsCase;
    }

    public Integer getContactsCutostomer() {
        return contactsCutostomer;
    }

    public void setContactsCutostomer(Integer contactsCutostomer) {
        this.contactsCutostomer = contactsCutostomer;
    }

    public List<Salefunnel> getSalefunnels() {
        return salefunnels;
    }

    public void setSalefunnels(List<Salefunnel> salefunnels) {
        this.salefunnels = salefunnels;
    }

    public Contacts() {
    }

    public Contacts(Integer contactsId, String contactsName, String contactsDuty, String contactsPhone, String contactsRole, String contactsCase, Integer contactsCutostomer) {
        this.contactsId = contactsId;
        this.contactsName = contactsName;
        this.contactsDuty = contactsDuty;
        this.contactsPhone = contactsPhone;
        this.contactsRole = contactsRole;
        this.contactsCase = contactsCase;
        this.contactsCutostomer = contactsCutostomer;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "contactsId=" + contactsId +
                ", contactsName=" + contactsName +
                ", contactsDuty='" + contactsDuty + '\'' +
                ", contactsPhone='" + contactsPhone + '\'' +
                ", contactsRole='" + contactsRole + '\'' +
                ", contactsCase='" + contactsCase + '\'' +
                ", contactsCutostomer=" + contactsCutostomer +
                '}';
    }
}
