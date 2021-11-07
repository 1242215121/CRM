package com.study.model.services.product;

import com.study.model.mapper.product.ProductMapper;
import com.study.model.mapper.product.TypeMapper;
import com.study.model.pojo.product.Product;
import com.study.model.pojo.product.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class TypeService {
    @Autowired
    TypeMapper typeMapper;

    @Autowired
    ProductMapper productMapper;

    /**
     * 查询所有类别
     */
    public List<Type> selType(){
        return typeMapper.selType();
    }


    /**
     * 查询所有类别
     */
    public List<Type> selAll(){
        return typeMapper.selAll();
    }

    /**
     * 新增类别
     */
    public Integer insertType(Type type){

        if(type.getParentId() == null){
            type.setParentId(0);
        }

        return typeMapper.insertType(type);
    }

    /**
     * 修改类别
     */
    public Integer updateType(Type type){
        if(type.getParentId() == null){
            type.setParentId(0);
        }
        return typeMapper.updateType(type);
    }

    /**
     * 删除类别
     */
    public Integer deleteType(String typeId){
        try{
            List<Product> products = productMapper.selTypeId(typeId);

            if(products.isEmpty()){
                return typeMapper.deleteType(typeId);
            }
            return 0;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

}
