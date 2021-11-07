package com.study.model.mapper.product;

import com.study.model.pojo.product.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    /**
     *
     * 查询所有产品
     */
    public List<Product> selPro();

    /**
     *
     * 新增产品
     */
    public Integer insertPro(Product product);
}
