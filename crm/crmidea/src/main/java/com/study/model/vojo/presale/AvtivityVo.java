package com.study.model.vojo.presale;

public class AvtivityVo {
    private Integer activityId;
    private String activityType;
    private String activityState;

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
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

    @Override
    public String toString() {
        return "AvtivityVo{" +
                "activityId=" + activityId +
                ", activityType='" + activityType + '\'' +
                ", activityState='" + activityState + '\'' +
                '}';
    }
}
