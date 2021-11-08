package com.study.controller.presale;

import com.study.model.pojo.presale.Activity;
import com.study.model.services.presale.ActivityService;
import com.study.model.vojo.presale.AvtivityVo;
import com.study.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
//    获取当前登录人
    @GetMapping("selectUser")
    public MyResult selectUser(Integer useid){
        System.out.println("根据当前负责人查询活动："+useid);
            return MyResult.SUCCESS_DATA(activityService.selectUser(useid));
    }
//    修改类型
    @PostMapping("upActivity")
    public MyResult upActivity(@RequestBody AvtivityVo avtivityVo){
        System.out.println("222222222222"+avtivityVo);
       Integer b = activityService.upActivity(avtivityVo.getActivityId(),
               avtivityVo.getActivityType(),avtivityVo.getActivityState());
       if (b>0){
           myResult.setCode(1);
           System.out.println("修改成功");
           return MyResult.SUCCESS;
       }
       return MyResult.FAILURE("修改失败");
    }
}
