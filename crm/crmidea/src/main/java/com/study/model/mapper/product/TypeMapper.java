package com.study.model.mapper.product;

import com.study.model.pojo.product.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TypeMapper {
    /**
     * 查询所有类别
     */
    public List<Type> selType();

    /**
     * 查询父级类别
     */
    public List<Type> selPar(String parentId);
}
