package com.study.model.pojo.power;

import com.study.model.pojo.insale.Refunds;
import com.study.model.pojo.presale.Activity;
import com.study.model.pojo.presale.Client;
import com.study.model.pojo.presale.Clue;

import java.sql.Date;
import java.util.List;

/**
 * 用户表
 */
public class Users {
    private Integer usersId;//编号
    private String usersName;//用户名
    private String usersPwd;//密码
    private String usersFullname;//姓名
    private Integer usersSex;//性别
    private Date usersBrith;//生日
    private String usersPhone;//电话
    private String usersEmail;//邮箱
    private String usersImgs;//头像地址
    private Integer state;//用户状态
    private Ajob ajob;//职位
    private Dept dept;//部门
    private Activity activity;//活动
    private Clue clue;//线索
    private Client client;//客户

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Clue getClue() {
        return clue;
    }

    public void setClue(Clue clue) {
        this.clue = clue;
    }

    private List<UsersRole> usersRole;//角色

    private List<Refunds> refunds;//退货单

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }


    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

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

    public Ajob getAjob() {
        return ajob;
    }

    public void setAjob(Ajob ajob) {
        this.ajob = ajob;
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

<<<<<<< .merge_file_a16172
<<<<<<< .merge_file_a28876
    private String usersFullnames;//用户名

    public String getUsersFullnames() {
        return usersFullnames;
    }

    public void setUsersFullnames(String usersFullnames) {
        this.usersFullnames = usersFullnames;
=======
    public List<Refunds> getRefunds() {
        return refunds;
    }

    public void setRefunds(List<Refunds> refunds) {
        this.refunds = refunds;
>>>>>>> .merge_file_a27524
=======
    @Override
    public String toString() {
        return "Users{" +
                "usersId=" + usersId +
                ", usersName='" + usersName + '\'' +
                ", usersPwd='" + usersPwd + '\'' +
                ", usersFullname='" + usersFullname + '\'' +
                ", usersSex=" + usersSex +
                ", usersBrith=" + usersBrith +
                ", usersPhone='" + usersPhone + '\'' +
                ", usersEmail='" + usersEmail + '\'' +
                ", usersImgs='" + usersImgs + '\'' +
                ", state=" + state +
                '}';
>>>>>>> .merge_file_a28344
    }
}
