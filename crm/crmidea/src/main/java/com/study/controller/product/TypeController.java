package com.study.controller.product;

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
}
