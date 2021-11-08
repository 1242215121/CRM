package com.study.model.pojo.power;

import com.study.model.pojo.presale.Activity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


/**
 * 部门
 */
public class Dept {
    private List<Users> users;//员工
    private List<Ajob> ajobs;//部门下的职位
    private Integer deptId;//部门编号
    private String deptName;//部门名称
    private String deptDesc;//部门描述
    private Activity activity;//活动

    public List<Ajob> getAjobs() {
        return ajobs;
    }

    public void setAjobs(List<Ajob> ajobs) {
        this.ajobs = ajobs;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptDesc() {
        return deptDesc;
    }

    public void setDeptDesc(String deptDesc) {
        this.deptDesc = deptDesc;
    }



}
