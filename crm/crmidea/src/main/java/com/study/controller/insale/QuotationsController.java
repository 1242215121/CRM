package com.study.controller.insale;

import com.study.model.services.insale.QuotationsService;
import com.study.model.vojo.insale.QuotationVo;
import com.study.model.vojo.insale.QuotationsNewVo;
import com.study.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quotations")
public class QuotationsController {

    @Autowired private QuotationsService service;
    MyResult myResult = new MyResult();

    /**
     *  关联销售机会查询所有报价单
     * @return
     */
    @GetMapping
    public MyResult selectAll(@RequestParam(value = "no",defaultValue = "10") Integer no,
                              @RequestParam(value = "size",defaultValue = "1")Integer size){
        System.out.println("查询所有报价单");
        return MyResult.SUCCESS_Object(service.selectAll(no, size));
    }

    @PostMapping("/many")
    public MyResult selectMany(@RequestBody QuotationVo quotationVo){
        System.out.println("报价单多条件查询：编号--"+quotationVo.getId()+",报价单名称："+quotationVo.getName());
        return MyResult.SUCCESS_Object(service.selectMany(
                quotationVo.getNo(),quotationVo.getSize(),
                quotationVo.getId(),quotationVo.getName()));
    }

    @GetMapping("/update")
    public MyResult updateStage(@RequestParam Integer qid){
        System.out.println("修改的报价单："+qid);
        Integer a = service.updateStage(qid);
        if(a>0){
            myResult.setCode(1);
            System.out.println("修改成功");
        }else {
            myResult.setCode(-1);
        }
        return myResult;
    }

    @PostMapping("/insert")
    public MyResult insert(@RequestBody QuotationsNewVo quotationsNewVo){
        System.out.println("新增报价单方法：报价单名称："+quotationsNewVo.getName()
                        +",报价单金额："+quotationsNewVo.getMoney()
                +",关联机会："+quotationsNewVo.getActivity() +",添加产品："+quotationsNewVo.getProduct());
        Integer q = service.insert(quotationsNewVo);
        if(q>0){
            myResult.setCode(1);
        }else {
            myResult.setCode(-1);
        }
        return myResult;
    }

}
