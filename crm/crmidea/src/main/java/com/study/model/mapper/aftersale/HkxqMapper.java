package com.study.model.mapper.aftersale;

import com.study.model.pojo.aftersale.Hk;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface HkxqMapper {
    public List<Hk> hkxqcx(String id);

}
