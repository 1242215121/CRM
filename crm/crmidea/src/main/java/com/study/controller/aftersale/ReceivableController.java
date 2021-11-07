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
    public MyResult getHk(Integer pageNo,Integer size,Integer zt,String nr,Integer id){
        System.out.println(zt);
        return MyResult.SUCCESS_Object(receivableService.hkcx(pageNo,size,zt,nr,id));
    }


    //回款确认
    @RequestMapping("hkqr")
    public void hkqr(@RequestBody Map<String,Object> map){
        System.out.println("输出：");
        System.out.println(map.get("hk"));
        receivableService.qrhk(map);
    }

    //回款驳回
    @RequestMapping("hkbh")
    public void hkbh(@RequestBody Map<String,Object> map){
        receivableService.bhhk(map);
    }
}
