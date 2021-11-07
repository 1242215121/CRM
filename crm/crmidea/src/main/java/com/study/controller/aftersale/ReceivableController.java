package com.study.controller.aftersale;

import com.study.model.services.aftersale.ReceivableService;
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
public class ReceivableController {
    @Autowired
    ReceivableService receivableService;

    //根据回款状态,回款编号，用户人查询回款记录
    @RequestMapping("hkcx")
    public MyResult getHk(Integer pageNo,Integer size,Integer zt,String nr){
        return MyResult.SUCCESS_Object(receivableService.hkcx(pageNo,size,zt,nr));
    }

    //根据订单名称查询回款记录
    @RequestMapping("hkjlcx")
    public MyResult getHkjl(Integer pageNo,Integer size,String nr){
        System.out.println("emm");
        System.out.println(pageNo);
        return MyResult.SUCCESS_Object(receivableService.hkjlcx(pageNo,size,nr));
    }


    //回款确认
    @RequestMapping("hkqr")
    public void hkqr(@RequestBody Map<String,Object> map){
        receivableService.qrhk(map);
    }

    //回款驳回
    @RequestMapping("hkbh")
    public void hkbh(@RequestBody Map<String,Object> map){
        receivableService.bhhk(map);
    }
}
