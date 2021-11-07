package com.study.controller.product;

import com.alibaba.fastjson.JSONObject;
import com.study.model.pojo.product.Product;
import com.study.model.services.product.ProductService;
import com.study.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RequestMapping("/hzc")
@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    /**
     *
     * 查询所有产品
     */
    @RequestMapping("/selPro")
    public MyResult selPro(){
        return  MyResult.SUCCESS_DATA(productService.selPro());

    }

    @GetMapping
    public MyResult selectAll(){
        System.out.println("查询所有产品");
        return MyResult.SUCCESS_DATA(productService.selectAll());
    }

    /**
     *
     * 新增产品
     */
    @RequestMapping("/insertPro")
    public MyResult insertPro(String product){
        try {
            Product product1 = JSONObject.parseObject(product, Product.class);
             productService.insertPro(product1);
            return MyResult.SUCCESS;
        }catch (Exception e){
            return MyResult.FAILURE("新增出错");
        }
    }

}
