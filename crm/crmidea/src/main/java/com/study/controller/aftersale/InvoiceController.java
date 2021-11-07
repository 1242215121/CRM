package com.study.controller.aftersale;

import com.study.model.services.aftersale.InvoiceService;
import com.study.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Repository
@RequestMapping("/llw")
@RestController
public class InvoiceController {
    @Autowired
    InvoiceService invoiceService;
    //根据订单名称模糊查询开票记录，或查询所有
    @RequestMapping("kpcx")
    public MyResult getKpcx(Integer pageNo, Integer size, String nr){
        return MyResult.SUCCESS_Object(invoiceService.qccx(pageNo,size,nr));
    }
}
