package com.study.model.mapper.insale;

import com.study.model.pojo.insale.Saleorder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SaleorderMapper {

    /**
     * 查询所有销售订单
     * @return
     */
    public List<Saleorder> selectAll();
}
