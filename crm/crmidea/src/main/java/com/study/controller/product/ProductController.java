package com.study.controller.product;

import com.study.model.pojo.product.Product;
import com.study.model.services.product.ProductService;
import com.study.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
}
