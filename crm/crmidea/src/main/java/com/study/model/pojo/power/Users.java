package com.study.model.pojo.power;

import com.study.model.pojo.insale.Salefunnel;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

public class Users {
    private Integer usersId;
    private String usersName;
    private String usersPwd;
    private String usersFullname;
    private Integer usersSex;
    private Date usersBrith;
    private String usersPhone;
    private String usersEmail;
    private String usersImgs;
    private Post post;
    private Dept dept;
    private List<UsersRole> usersRole;

    private List<Salefunnel> salefunnels;//一个员工可负责多个销售机会

    public Integer getUsersId() {
        return usersId;
    }

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    public String getUsersName() {
        return usersName;
    }

    public void setUsersName(String usersName) {
        this.usersName = usersName;
    }

    public String getUsersPwd() {
        return usersPwd;
    }

    public void setUsersPwd(String usersPwd) {
        this.usersPwd = usersPwd;
    }

    public String getUsersFullname() {
        return usersFullname;
    }

    public void setUsersFullname(String usersFullname) {
        this.usersFullname = usersFullname;
    }

    public Integer getUsersSex() {
        return usersSex;
    }

    public void setUsersSex(Integer usersSex) {
        this.usersSex = usersSex;
    }

    public Date getUsersBrith() {
        return usersBrith;
    }

    public void setUsersBrith(Date usersBrith) {
        this.usersBrith = usersBrith;
    }

    public String getUsersPhone() {
        return usersPhone;
    }

    public void setUsersPhone(String usersPhone) {
        this.usersPhone = usersPhone;
    }

    public String getUsersEmail() {
        return usersEmail;
    }

    public void setUsersEmail(String usersEmail) {
        this.usersEmail = usersEmail;
    }

    public String getUsersImgs() {
        return usersImgs;
    }

    public void setUsersImgs(String usersImgs) {
        this.usersImgs = usersImgs;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public List<UsersRole> getUsersRole() {
        return usersRole;
    }

    public void setUsersRole(List<UsersRole> usersRole) {
        this.usersRole = usersRole;
    }

    public List<Salefunnel> getSalefunnels() {
        return salefunnels;
    }

    public void setSalefunnels(List<Salefunnel> salefunnels) {
        this.salefunnels = salefunnels;
    }
}
