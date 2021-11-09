package com.study.controller.product;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.study.model.pojo.product.Bill;
import com.study.model.pojo.product.Bills;
import com.study.model.services.product.BillService;
import com.study.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RequestMapping("/hzc")
@RestController
public class BillController {

    @Autowired
    BillService billService;

    /**
     * 查询所有出入库单
     */
    @RequestMapping("/selectBill")
    public MyResult selectBill(String bill){
        Bill bill1 = JSONObject.parseObject(bill, Bill.class);
        return MyResult.SUCCESS_DATA(billService.selectBill(bill1));
    }
    @RequestMapping("/selectBill1")
    public MyResult selectBill1(String bill){
        Bill bill1 = JSONObject.parseObject(bill, Bill.class);
        return MyResult.SUCCESS_DATA(billService.selectBill1(bill1));
    }

    /**
     * 新增出入库单
     */
    @RequestMapping("/insertBill")
    public MyResult insertBill(@RequestBody Bill bill){

        try {
            billService.insertBill(bill);
            return MyResult.SUCCESS;
        }catch (Exception e){
            return MyResult.FAILURE("新增出错");
        }
    }

    /**
     * 办理出入库单
     */
    @RequestMapping("/updateBill")
    public MyResult updateBill(@RequestBody Bill bill){

        try {
            billService.updateBill(bill);
            return MyResult.SUCCESS;
        }catch (Exception e){
            return MyResult.FAILURE("修改出错");
        }
    }

    /**
     * 根据id删除出入库单
     */
    @RequestMapping("/deleteBill")
    public MyResult deleteBill(String billId){

        try {
            billService.deleteBill(billId);
            return MyResult.SUCCESS;
        }catch (Exception e){
            return MyResult.FAILURE("删除出错");
        }

    }


}
