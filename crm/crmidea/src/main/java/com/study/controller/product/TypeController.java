package com.study.controller.product;

import com.alibaba.fastjson.JSONObject;
import com.study.model.pojo.product.Product;
import com.study.model.pojo.product.Type;
import com.study.model.services.product.TypeService;
import com.study.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RequestMapping("/hzc")
@RestController
public class TypeController {
    @Autowired
    TypeService typeService;

    /**
     * 查询所有类别
     */
    @RequestMapping("/selType")
    public MyResult selType(){
        return MyResult.SUCCESS_DATA(typeService.selType());
    }

    /**
     * 查询所有类别
     */
    @RequestMapping("/selAll")
    public MyResult selAll(){
        return MyResult.SUCCESS_DATA(typeService.selAll());
    }

    /**
     * 新增类别
     */
    @RequestMapping("/insertType")
    public MyResult insertType(String type){
        try {
            Type type1 = JSONObject.parseObject(type, Type.class);
            typeService.insertType(type1);
            return MyResult.SUCCESS;
        }catch (Exception e){
            return MyResult.FAILURE("新增出错");
        }
    }

    /**
     * 修改类别
     */
    @RequestMapping("/updateType")
    public MyResult updateType(String type){
        try {
            Type type1 = JSONObject.parseObject(type, Type.class);
            typeService.updateType(type1);
            return MyResult.SUCCESS;
        }catch (Exception e){
            return MyResult.FAILURE("修改出错");
        }
    }


    /**
     * 删除类别
     */
    @RequestMapping("/deleteType")
    public MyResult deleteType(String typeId){

        Integer integer = typeService.deleteType(typeId);

        if(integer==0){
            return MyResult.FAILURE("该类别关联了产品，不能删除！");
        }
        return MyResult.SUCCESS;

    }
}
