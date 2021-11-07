package com.study.model.services.product;

import com.study.model.mapper.product.TypeMapper;
import com.study.model.pojo.product.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TypeService {
    @Autowired
    TypeMapper typeMapper;

    /**
     * 查询所有类别
     */
    public List<Type> selType(){
        return typeMapper.selType();
    }
}
