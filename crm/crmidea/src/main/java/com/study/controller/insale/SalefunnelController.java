package com.study.controller.insale;

import com.study.model.services.insale.SalefunnelService;
import com.study.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 销售机会
 */
@RestController
@RequestMapping("/salefunnel")
public class SalefunnelController {

    @Autowired private SalefunnelService service;

    MyResult myResult = new MyResult();

    /**
     * 连接客户表，员工表，市场活动表，联系人表，查询销售机会
     * @return
     */
    @GetMapping
    public MyResult selectAll(@RequestParam(value = "no",defaultValue = "10") Integer no,
                              @RequestParam(value = "size",defaultValue = "1")Integer size){
        System.out.println("查询所有销售机会");
        return MyResult.SUCCESS_Object(service.selectAll(no, size));
    }
}
