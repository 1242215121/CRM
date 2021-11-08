package com.study.controller.insale;

import com.study.model.services.insale.RefundproService;
import com.study.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/refundspro")
public class RefundproController {

    @Autowired private RefundproService service;

    @GetMapping
    public MyResult selectByRid(@RequestParam Integer rid){
        System.out.println("根据退货单编号，查询产品："+rid);
        return MyResult.SUCCESS_DATA(service.selectByRid(rid));
    }
}
