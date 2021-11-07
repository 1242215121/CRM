package com.study.controller.presale;

import com.study.model.pojo.presale.Activity;
import com.study.model.services.presale.ActivityService;
import com.study.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("activity")
public class ActivityController {
    MyResult myResult =new MyResult();
    @Autowired
    ActivityService activityService;
    @RequestMapping("/seActivity")
    public MyResult seActivity(@RequestBody Activity activity){
        return MyResult.SUCCESS_Object(activityService.seActivityByPage(activity.getPageNo(),activity.getSize(),
                activity.getActivityName(),activity.getActivityAddress()));
    }
    @GetMapping
    public MyResult seAct(){
        return  MyResult.SUCCESS_DATA(activityService.seAct());
    }
    public MyResult inActivity(Activity activity){
        Integer a = activityService.inActivity(activity);
        if(a>0){
            myResult.setCode(-1);
            System.err.println("新增成功");
        }
        return myResult;
    }
}
