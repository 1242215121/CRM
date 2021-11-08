package com.study.model.mapper.insale;

import com.study.model.pojo.insale.Saleorder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
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
     * 根据销售订单查询所有
     * @param soid
     * @return
     */
    public Saleorder selectBySoid(Integer soid);

    /**
     * 根据销售订单编号修改退货单金额
     * @param soid
     * @return
     */
    public Integer updateByStatu(@Param("soid") Integer soid, @Param("money")BigDecimal money);

    /**
     * 新增销售订单
     * @param saleorder
     * @return
     */
    public Integer insert(Saleorder saleorder);
}
