package com.study.model.mapper.presale;


import com.study.model.pojo.presale.Activity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ActivityMapper {
    //分页联表查询
    public List<Activity> seActivity(@Param("activityName")String activityName,@Param("activityAddress")String activityAddres);

    //模糊查询
    public List<Activity> seAct();

    //新增活动表
    public Integer inActivity(Activity activity);

}
