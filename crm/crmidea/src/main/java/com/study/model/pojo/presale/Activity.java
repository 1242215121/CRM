package com.study.model.pojo.presale;

import java.sql.Date;

public class Activity {
    private Integer activityId;
    private String activityName;
    private Integer activityUser;
    private Date activityStart;
    private Date activityOver;
    private String activityAddress;
    private String activityType;
    private String activityState;
    private Integer activityPlanCost;
    private Integer activityRealityCost;
    private String activityPlan;
    private Integer activityPlanIncome;
    private Integer activityRealityIncome;


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
