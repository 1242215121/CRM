package com.study.model.mapper.insale;

import com.study.model.pojo.insale.Refunds;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RefundsMapper {

    /**
     * 连表查询所有退货单信息
     * @return
     */
    public List<Refunds> selectAll();


    /**
     * 多条件查询
     * @param id
     * @param name
     * @return
     */
    public List<Refunds> selectMany(@Param("id") Integer id, @Param("name") String name);

    /**
     * 根据销售订单查询退货信息
     * @param soid
     * @return
     */
    public List<Refunds> selectRefundsBySoid(Integer soid);

    /**
     * 新增
     * @param refunds
     * @return
     */
    public Integer insert(Refunds refunds);
}
