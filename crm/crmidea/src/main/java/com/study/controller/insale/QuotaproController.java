package com.study.controller.insale;

import com.study.model.services.insale.QuotaproService;
import com.study.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quotapro")
public class QuotaproController {

    @Autowired private QuotaproService service;

    /**
     * 根据报价单编号获取产品信息
     * @param qid
     * @return
     */
    @GetMapping
    public MyResult selectByQid(@RequestParam Integer qid){
        System.out.println("根据报价单编号，查询产品："+qid);
        return MyResult.SUCCESS_DATA(service.selectByQid(qid));
    }
}
