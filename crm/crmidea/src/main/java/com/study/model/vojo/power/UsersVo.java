package com.study.model.vojo.power;

/**
 * 用户多条件查询
 */
public class UsersVo {
    private String name;//姓名
    private Integer deptid;//部门
    private Integer ajobid;//职位

    @Override
    public String toString() {
        return "UsersVo{" +
                "name='" + name + '\'' +
                ", deptid=" + deptid +
                ", ajobid=" + ajobid +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public Integer getAjobid() {
        return ajobid;
    }

    public void setAjobid(Integer ajobid) {
        this.ajobid = ajobid;
    }
}
