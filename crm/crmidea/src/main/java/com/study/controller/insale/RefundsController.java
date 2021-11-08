package com.study.controller.insale;

import com.study.model.services.insale.RefundsService;
import com.study.model.vojo.insale.RefundsNewVo;
import com.study.model.vojo.insale.SalefunnelVo;
import com.study.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/refunds")
public class RefundsController {

    @Autowired private RefundsService service;

    MyResult myResult = new MyResult();

    @GetMapping("/select")
    public MyResult select(@RequestParam Integer soid){
        System.out.println("根据销售订单查询退货信息："+soid);
        return MyResult.SUCCESS_DATA(service.selectRefundsBySoid(soid));
    }

    /**
     * 连表查询所有退货单信息
     * @param no
     * @param size
     * @return
     */
    @GetMapping
    public MyResult selectAll(@RequestParam(value = "no",defaultValue = "10") Integer no,
                              @RequestParam(value = "size",defaultValue = "1")Integer size){
        System.out.println("连表查询所有退货单信息");
        return MyResult.SUCCESS_Object(service.selectAll(no, size));
    }

    /**
     * 多条件查询
     * @param salefunnelVo
     * @return
     */
    @PostMapping("/many")
    public MyResult selectMany(@RequestBody SalefunnelVo salefunnelVo){
        System.out.println("退货单多条件查询：编号--"+salefunnelVo.getId()+",机会名称："+salefunnelVo.getName());
        return MyResult.SUCCESS_Object(service.selectMany(
                salefunnelVo.getNo(),salefunnelVo.getSize(),
                salefunnelVo.getId(),salefunnelVo.getName()));
    }

    @PostMapping("/insert")
    public MyResult insert(@RequestBody RefundsNewVo refundsNewVo){
        System.out.println("新增销售机会方法：退货单名称："+refundsNewVo.getName()
                +",负责人员："+refundsNewVo.getUserid()+",退货原因："+refundsNewVo.getReason()
                +",退货方式："+refundsNewVo.getWay()+",销售订单编号："+refundsNewVo.getSoId()
                +",退货时间："+refundsNewVo.getStarttime()+",联系电话："+refundsNewVo.getTel());
        Integer s = service.insert(refundsNewVo);
        if(s>0){
            myResult.setCode(1);
        }else {
            myResult.setCode(-1);
        }
        return myResult;
    }
}
