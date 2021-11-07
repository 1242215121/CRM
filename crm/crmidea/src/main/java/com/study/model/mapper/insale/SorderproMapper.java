package com.study.model.mapper.insale;

import com.study.model.pojo.insale.Sorderpro;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SorderproMapper {

    /**
     * 根据销售订单查询产品信息
     * @param soid
     * @return
     */
    public List<Sorderpro> selectBySoid(Integer soid);
}
