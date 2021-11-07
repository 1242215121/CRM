package com.study.controller.presale;

import com.study.model.services.presale.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("activity")
public class ActivityController {
    @Autowired
    ActivityService activityService;
    @RequestMapping("/seActivity")
    public Object seActivity(Integer pageNo,Integer size){
        System.err.println("eeee"+activityService.seActivityByPage(pageNo,size).toString());
        return activityService.seActivityByPage(pageNo,size);
    }
}
