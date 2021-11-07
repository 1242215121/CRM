package com.study.controller.insale;

import com.study.model.services.insale.SaleproService;
import com.study.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/salepro")
/**
 * 销售机会
 */
public class SaleproController {

    @Autowired private SaleproService service;

    /**
     * 根据销售机会编号查询产品信息
     * @param sfid
     * @return
     */
    @GetMapping
    public MyResult selectBySfid(@RequestParam Integer sfid){
        System.out.println("销售机会编号："+sfid);
        return MyResult.SUCCESS_DATA(service.selectBySfid(sfid));
    }
}
