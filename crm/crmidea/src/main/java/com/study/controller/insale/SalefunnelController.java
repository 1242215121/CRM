package com.study.controller.insale;

import com.study.model.services.insale.SalefunnelService;
import com.study.model.vojo.insale.SalefunnelNewVo;
import com.study.model.vojo.insale.SalefunnelVo;
import com.study.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 销售机会
 */
@RestController
@RequestMapping("/salefunnel")
public class SalefunnelController {

    @Autowired private SalefunnelService service;

    MyResult myResult = new MyResult();

    /**
     * 单表查询销售机会
     * @return
     */
    @GetMapping("/select")
    public MyResult select(){
        System.out.println("单表查询所有销售机会");
        return MyResult.SUCCESS_DATA(service.select());
    }

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

    @PostMapping("/many")
    public MyResult selectMany(@RequestBody SalefunnelVo salefunnelVo){
        System.out.println("销售机会多条件查询：编号--"+salefunnelVo.getId()+",机会名称："+salefunnelVo.getName());
        return MyResult.SUCCESS_Object(service.selectMany(
                salefunnelVo.getNo(),salefunnelVo.getSize(),
                salefunnelVo.getId(),salefunnelVo.getName()));
    }

    @PostMapping("/insert")
    public MyResult insert(@RequestBody SalefunnelNewVo salefunnelNewVo){
        System.out.println("新增销售机会方法：机会名称："+salefunnelNewVo.getName()
                +",负责人员："+salefunnelNewVo.getEmp()+",所属客户："+salefunnelNewVo.getCustom()
                +",联系人员："+salefunnelNewVo.getPerson()+",关联活动："+salefunnelNewVo.getActivity()
                +",预计成交日："+salefunnelNewVo.getStarttime()+",添加产品："+salefunnelNewVo.getProduct());
        Integer s = service.insert(salefunnelNewVo);
        if(s>0){
            myResult.setCode(1);
        }else {
            myResult.setCode(-1);
        }
        return myResult;
    }
}
