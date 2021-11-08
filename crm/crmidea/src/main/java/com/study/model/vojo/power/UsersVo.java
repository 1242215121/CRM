package com.study.model.vojo.power;

/**
 * 用户多条件查询
 */
public class UsersVo {
    private String name;//姓名
    private Integer deptid;//部们
    private Integer ajobid;//职位
    private Integer pageNo;//当前页
    private Integer pageSize;//最大条数
    private Integer state;//状态

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "UsersVo{" +
                "name='" + name + '\'' +
                ", deptid=" + deptid +
                ", ajobid=" + ajobid +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
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
