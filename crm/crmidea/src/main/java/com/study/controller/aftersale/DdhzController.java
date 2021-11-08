package com.study.controller.aftersale;

import com.study.model.mapper.aftersale.DdhzMapper;
import com.study.model.services.aftersale.DdhzService;
import com.study.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Repository
@RequestMapping("/llw")
@RestController
public class DdhzController {
    @Autowired
    DdhzService ddhzService;

    @RequestMapping("ddcx")
    public MyResult getKpcx(Integer pageNo, Integer size, String nr){
        return MyResult.SUCCESS_Object(ddhzService.ddcx(pageNo,size,nr));
    }
}
