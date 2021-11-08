package com.study.controller.presale;

import com.study.model.pojo.presale.Activity;
import com.study.model.services.presale.ActivityService;
import com.study.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("activity")
public class ActivityController {
    MyResult myResult =new MyResult();
    @Autowired
    ActivityService activityService;
//    分页 模糊 联表查询
    @RequestMapping("/seActivity")
    public MyResult seActivity(@RequestBody Activity activity){
        return MyResult.SUCCESS_Object(activityService.seActivityByPage(activity.getPageNo(),activity.getSize(),
                activity.getActivityName(),activity.getActivityAddress()));
    }
//    查所有
    @GetMapping("select")
    public MyResult seAct(){
        return  MyResult.SUCCESS_DATA(activityService.seAct());
    }
//    新增
    @PostMapping("inActivity")
    public MyResult inActivity(@RequestBody Activity activity){
        System.out.println(activity);
        Integer a = activityService.inActivity(activity);
        if(a>0){
            myResult.setCode(1);
            System.err.println("新增成功");
            return MyResult.SUCCESS;
        }
        return MyResult.FAILURE("新增失败");
    }
}
