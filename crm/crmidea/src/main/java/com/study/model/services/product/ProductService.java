package com.study.model.services.product;

import com.alibaba.fastjson.JSONArray;
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
    public List<Product> selPro(Product product){
        return productMapper.selPro(product);
    }

    /**
     * 查询所有产品
     * @return
     */
    public List<Product> selectAll(){
        return productMapper.selectAll();
    }

    /**
     *
     * 新增产品
     */
    public Integer insertPro(Product product){
        return productMapper.insertPro(product);
    }

    /**
     * 修改产品
     */
    public Integer updatePro(Product product){
        return productMapper.updatePro(product);
    }

    /**
     *
     * 根据类别id查产品
     */
    public List<Product> selTypeId(String typeId){
        return productMapper.selTypeId(typeId);
    }

    /**
     * 批量修改产品
     */
    public Integer batchType(List<Product> pitch){
        return productMapper.batchType(pitch);
    }

}
