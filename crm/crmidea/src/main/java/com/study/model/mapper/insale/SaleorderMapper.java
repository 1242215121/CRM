package com.study.model.mapper.insale;

import com.study.model.pojo.insale.Saleorder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

    /**
     * 多条件查询
     * @param id
     * @param name
     * @return
     */
    public List<Saleorder> selectMany(@Param("id") Integer id, @Param("name") String name);

    /**
     * 新增销售订单
     * @param saleorder
     * @return
     */
    public Integer insert(Saleorder saleorder);
}
