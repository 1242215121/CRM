package com.study.model.services.presale;

import com.study.model.mapper.presale.ActivityMapper;
import com.study.model.pojo.presale.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ActivityService {
    @Autowired
    ActivityMapper activityMapper;
    public List<Activity> seActivity(){
        return activityMapper.seActivity();
    }

}
