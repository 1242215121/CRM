package com.study.model.pojo.presale;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.study.model.pojo.power.Users;

import java.sql.Date;

/**
 * 活动
 **/
public class Activity {
    private Integer activityId;//活动id
    private String activityName;//活动名称
    private Integer activityUser;//所属团队
    private Date activityStart;//开始时间
    private Date activityOver;//结束时间
    private String activityAddress;//活动地址
    private String activityType;//活动类型
    private String activityState;//活动状态
    private Integer activityPlanCost;//计划成本
    private Integer activityRealityCost;//实际成本
    private String activityPlan;//计划收入
    private Integer activityPlanIncome;//实际收入
    private Integer activityRealityIncome;//活动计划
    private Users users;


    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Integer getActivityUser() {
        return activityUser;
    }

    public void setActivityUser(Integer activityUser) {
        this.activityUser = activityUser;
    }

    public Date getActivityStart() {
        return activityStart;
    }

    public void setActivityStart(Date activityStart) {
        this.activityStart = activityStart;
    }

    public Date getActivityOver() {
        return activityOver;
    }

    public void setActivityOver(Date activityOver) {
        this.activityOver = activityOver;
    }

    public String getActivityAddress() {
        return activityAddress;
    }

    public void setActivityAddress(String activityAddress) {
        this.activityAddress = activityAddress;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getActivityState() {
        return activityState;
    }

    public void setActivityState(String activityState) {
        this.activityState = activityState;
    }

    public Integer getActivityPlanCost() {
        return activityPlanCost;
    }

    public void setActivityPlanCost(Integer activityPlanCost) {
        this.activityPlanCost = activityPlanCost;
    }

    public Integer getActivityRealityCost() {
        return activityRealityCost;
    }

    public void setActivityRealityCost(Integer activityRealityCost) {
        this.activityRealityCost = activityRealityCost;
    }

    public String getActivityPlan() {
        return activityPlan;
    }

    public void setActivityPlan(String activityPlan) {
        this.activityPlan = activityPlan;
    }

    public Integer getActivityPlanIncome() {
        return activityPlanIncome;
    }

    public void setActivityPlanIncome(Integer activityPlanIncome) {
        this.activityPlanIncome = activityPlanIncome;
    }

    public Integer getActivityRealityIncome() {
        return activityRealityIncome;
    }

    public void setActivityRealityIncome(Integer activityRealityIncome) {
        this.activityRealityIncome = activityRealityIncome;
    }

    public Activity() {
    }

    public Activity(Integer activityId, String activityName, Date activityStart, Date activityOver, String activityAddress, String activityType, String activityState, Integer activityPlanCost, Integer activityRealityCost, String activityPlan, Integer activityPlanIncome, Integer activityRealityIncome) {
        this.activityId = activityId;
        this.activityName = activityName;
        this.activityStart = activityStart;
        this.activityOver = activityOver;
        this.activityAddress = activityAddress;
        this.activityType = activityType;
        this.activityState = activityState;
        this.activityPlanCost = activityPlanCost;
        this.activityRealityCost = activityRealityCost;
        this.activityPlan = activityPlan;
        this.activityPlanIncome = activityPlanIncome;
        this.activityRealityIncome = activityRealityIncome;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "activityId=" + activityId +
                ", activityName='" + activityName + '\'' +
                ", activityUser=" + activityUser +
                ", activityStart=" + activityStart +
                ", activityOver=" + activityOver +
                ", activityAddress='" + activityAddress + '\'' +
                ", activityType='" + activityType + '\'' +
                ", activityState='" + activityState + '\'' +
                ", activityPlanCost=" + activityPlanCost +
                ", activityRealityCost=" + activityRealityCost +
                ", activityPlan='" + activityPlan + '\'' +
                ", activityPlanIncome=" + activityPlanIncome +
                ", activityRealityIncome=" + activityRealityIncome +
                '}';
    }
}
