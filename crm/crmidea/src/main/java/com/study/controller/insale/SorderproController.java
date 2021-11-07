package com.study.controller.insale;

import com.study.model.services.insale.SorderproService;
import com.study.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sorderpro")
public class SorderproController {

    @Autowired private SorderproService service;

    /**
     * 根据销售订单编号查找产品信息
     * @param soid
     * @return
     */
    @GetMapping
    public MyResult selectBySfid(@RequestParam Integer soid){
        System.out.println("根据销售订单编号查找产品信息："+soid);
        return MyResult.SUCCESS_DATA(service.selectBySoid(soid));
    }
}
