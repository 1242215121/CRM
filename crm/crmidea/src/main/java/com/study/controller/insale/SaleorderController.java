package com.study.controller.insale;

import com.study.model.services.insale.SaleorderService;
import com.study.model.vojo.insale.SaleorderVo;
import com.study.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/saleorder")
public class SaleorderController {

    @Autowired private SaleorderService service;

    MyResult myResult = new MyResult();

    /**
     * 查询所有销售订单
     * @param no
     * @param size
     * @return
     */
    @GetMapping
    public MyResult selectAll(@RequestParam(value = "no",defaultValue = "10") Integer no,
                              @RequestParam(value = "size",defaultValue = "1")Integer size){
        System.out.println("查询所有销售订单");
        return MyResult.SUCCESS_Object(service.selectAll(no, size));
    }

    /**
     * 多条件查询
     * @param saleorderVo
     * @return
     */
    @PostMapping("/many")
    public MyResult selectMany(@RequestBody SaleorderVo saleorderVo){
        System.out.println("销售订单多条件查询：编号--"+saleorderVo.getId()+",机会名称："+saleorderVo.getName());
        return MyResult.SUCCESS_Object(service.selectMany(
                saleorderVo.getNo(),saleorderVo.getSize(),
                saleorderVo.getId(),saleorderVo.getName()));
    }
}
