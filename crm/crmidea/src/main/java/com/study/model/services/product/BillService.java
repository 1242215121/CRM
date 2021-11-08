package com.study.model.services.product;

import com.study.model.mapper.product.BillMapper;
import com.study.model.mapper.product.ProductMapper;
import com.study.model.pojo.product.Bill;
import com.study.model.pojo.product.Bills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class BillService {
    @Autowired
    BillMapper billMapper;

    @Autowired
    ProductMapper productMapper;

    /**
     * 查询所有出入库单
     */
    public List<Bill> selectBill(Bill bill){
        return billMapper.selectBill(bill);
    }
    public List<Bill> selectBill1(Bill bill){
        return billMapper.selectBill1(bill);
    }

    /**
     * 新增出入库单
     */
    public Integer insertBill(Bill bill){
        //新增出入库单主表
        billMapper.insertBill(bill);

        List<Bills> bills = bill.getBills();
        for (Bills b:bills) {

            b.setBillId(bill.getBillId());
        }

        return billMapper.insertBills(bills);
    }

    /**
     * 办理出入库单
     */
    public Integer updateBill(Bill bill){
        List<Bills> bills = bill.getBills();

        //等于1就是入库
        if(bill.getBillAction() == 1){
            for (Bills b:bills) {
                //修改产品库存
                productMapper.updateGo(b.getBillsCount()+"",b.getPreId());
            }
        }else{
            for (Bills b:bills) {
                //修改产品库存
                productMapper.updateJoin(b.getBillsCount()+"",b.getPreId());
            }
        }

        //修改出入库单
        return billMapper.updateBill(bill);
    }

    /**
     * 根据id删除出入库单
     */
    public Integer deleteBill(String billId){
        billMapper.deleteBills(billId);
        return billMapper.deleteBill(billId);
    }



}
