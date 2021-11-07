package com.study.controller.aftersale;

import com.study.model.services.aftersale.HkxqService;
import com.study.model.services.aftersale.ReceivableService;
import com.study.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Repository
@RequestMapping("/llw")
@RestController
public class HkxqController {
    @Autowired
    HkxqService hkxqService;

    //根据回款状态,回款编号，用户人查询回款记录
    @RequestMapping("hkxqcx")
    public MyResult getHkxq(String id){
        return MyResult.SUCCESS_Object(hkxqService.hkxqcx(id));
    }
}
