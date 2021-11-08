package com.study.model.mapper.product;

import com.alibaba.fastjson.JSONArray;
import com.study.model.pojo.product.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {

    /**
     *
     * 查询所有产品
     */
    public List<Product> selPro(Product product);

    /**
     * 查询所有产品
     * @return
     */
    public List<Product> selectAll();

    /**
     *
     * 新增产品
     */
    public Integer insertPro(Product product);

    /**
     * 修改产品
     */
    public Integer updatePro(Product product);

    /**
     *
     * 根据类别id查产品
     */
    public List<Product> selTypeId(String typeId);

    /**
     * 批量修改产品
     */
    public Integer batchType( List<Product> pitch);

}
