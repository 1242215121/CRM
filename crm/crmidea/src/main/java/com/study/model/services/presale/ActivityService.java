package com.study.model.services.presale;

import com.study.model.mapper.presale.ActivityMapper;
import com.study.model.pojo.presale.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@Transactional
public class ActivityService {
    @Autowired
    ActivityMapper activityMapper;
    public Object seActivityByPage(Integer pageNo,Integer size,String activityName, String activityAddress){
        return activityMapper.seActivity(activityName, activityAddress);
    }
    public List<Activity> seAct(){
        return activityMapper.seAct();
    }
    public Integer inActivity(Activity activity){
        return activityMapper.inActivity(activity);
    }
}
