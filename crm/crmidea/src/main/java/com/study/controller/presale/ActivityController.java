package com.study.controller.presale;

import com.study.model.pojo.presale.Activity;
import com.study.model.services.presale.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("activity")
public class ActivityController {
    @Autowired
    ActivityService activityService;
    @RequestMapping("/seActivity")
    public List<Activity> seActivity(){
        System.err.println(activityService.seActivity());
        return activityService.seActivity();
    }
}
