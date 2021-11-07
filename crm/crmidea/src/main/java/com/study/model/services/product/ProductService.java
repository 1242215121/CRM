package com.study.model.services.product;

import com.study.model.mapper.product.ProductMapper;
import com.study.model.pojo.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProductService {
    @Autowired
    ProductMapper productMapper;

    /**
     *
     * 查询所有产品
     */
    public List<Product> selPro(){
        return productMapper.selPro();
    }

    /**
     *
     * 新增产品
     */
    public Integer insertPro(Product product){
        try{
            productMapper.insertPro(product);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

}
