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

    /**
     * 查询所有类别
     */
    public List<Type> selAll();

    /**
     * 新增类别
     */
    public Integer insertType(Type type);

    /**
     * 修改类别
     */
    public Integer updateType(Type type);

    /**
     * 删除类别
     */
    public Integer deleteType(String typeId);
}
