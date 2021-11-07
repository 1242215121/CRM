package com.study.model.mapper.insale;

import com.study.model.pojo.insale.Salepro;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
/**
 * 销售机会和产品中间表
 */
public interface SaleproMapper {

    /**
     * 根据销售机会编号查询产品信息
     * @param sfid
     * @return
     */
    public List<Salepro> selectBySfid(Integer sfid);

    /**
     * 新增中间表
     * @param num
     * @param salefunnel
     * @param product
     * @return
     */
    public Integer insert(@Param("num") Integer num,@Param("salefunnel") Integer salefunnel, @Param("product") String product);
}
