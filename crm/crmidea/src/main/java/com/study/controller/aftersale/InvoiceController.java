package com.study.controller.aftersale;

import com.study.model.services.aftersale.InvoiceService;
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
public class InvoiceController {
    @Autowired
    InvoiceService invoiceService;
    //根据订单名称模糊查询开票记录，或查询所有
    @RequestMapping("kpcx")
    public MyResult getKpcx(Integer pageNo, Integer size, String nr){
        return MyResult.SUCCESS_Object(invoiceService.kpcx(pageNo,size,nr));
    }

    //根据订单名称模糊查询开票记录
    @RequestMapping("kpblcx")
    public MyResult getKpblcx(Integer pageNo, Integer size,Integer zt,String nr){
        return MyResult.SUCCESS_Object(invoiceService.kpblcx(pageNo,size,zt,nr));
    }

    //确认开票办理
    @RequestMapping("qrbl")
    public MyResult kpqr(@RequestBody Map<String,Object> map){
        return MyResult.SUCCESS_Object(invoiceService.qrbl(map));
    }

    //驳回开票办理
    @RequestMapping("kpbhbl")
    public MyResult kpbh(@RequestBody Map<String,Object> map){

        return MyResult.SUCCESS_Object(invoiceService.bhbl(map));
    }
}
