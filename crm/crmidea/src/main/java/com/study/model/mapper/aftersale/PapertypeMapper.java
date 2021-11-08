package com.study.model.mapper.aftersale;

import com.study.model.pojo.aftersale.Papertype;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PapertypeMapper {
    public List<Papertype> pjlxcx();
}
