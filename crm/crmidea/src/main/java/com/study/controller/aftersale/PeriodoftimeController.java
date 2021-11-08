package com.study.controller.aftersale;

import com.study.model.pojo.aftersale.Periodoftime;
import com.study.model.services.aftersale.PeriodoftimeService;
import com.study.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Repository
@RequestMapping("/llw")
@RestController
public class PeriodoftimeController {
    @Autowired
    PeriodoftimeService periodoftimeService;

    //根据订单编号查询期次
    @RequestMapping("qcddcx")
    public MyResult getQcdd(Integer id){
        return MyResult.SUCCESS_Object(periodoftimeService.qcddcx(id));
    }

    //根据订单名称模糊查询计划期次，或查询所有
    @RequestMapping("qccx")
    public MyResult getQccx(Integer pageNo,Integer size,String nr){
        return MyResult.SUCCESS_Object(periodoftimeService.qccx(pageNo,size,nr));
    }

    //期次新增
    @RequestMapping("qcxz")
    public MyResult qcxz(@RequestBody Periodoftime periodoftime){
        return MyResult.SUCCESS_Object(periodoftimeService.qcxz(periodoftime));
    }

    //删除期次
    @RequestMapping("qcdel")
    public MyResult qcdel(@RequestBody Periodoftime periodoftime){
        return MyResult.SUCCESS_Object(periodoftimeService.del(periodoftime));
    }
}
