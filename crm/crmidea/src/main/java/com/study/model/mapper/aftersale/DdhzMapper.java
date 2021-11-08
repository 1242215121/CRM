package com.study.model.mapper.aftersale;

import com.study.model.pojo.insale.Saleorder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface DdhzMapper {
    //查询所有订单，或根据订单名称模糊查询
    public List<Saleorder> ddcx(String nr);
}
