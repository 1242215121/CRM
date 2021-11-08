package com.study.model.mapper.product;

import com.study.model.pojo.product.Bill;
import com.study.model.pojo.product.Bills;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BillMapper {
    /**
     * 查询所有出入库单
     */
    public List<Bill> selectBill(Bill bill);
    public List<Bill> selectBill1(Bill bill);
    /**
     * 新增出入库单
     */
    public Integer insertBill(Bill bill);

    /**
     * 批量新增出入库详单
     */
    public Integer insertBills(@Param("billsList") List<Bills> billsList);

    /**
     * 办理出入库单
     */
    public Integer updateBill(Bill bill);

    /**
     * 根据id删除出入库单
     */
    public Integer deleteBill(String billId);
    /**
     * 根据id删除出入库详单
     */
    public Integer deleteBills(String billId);
}
