package com.study.model.services.insale;

import com.study.model.mapper.insale.SaleproMapper;
import com.study.model.pojo.insale.Salefunnel;
import com.study.model.pojo.insale.Salepro;
import com.study.model.pojo.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
/**
 * 销售机会和产品中间表
 */
public class SaleproService {

    @Autowired private SaleproMapper mapper;

    /**
     * 根据销售机会编号查询产品信息
     * @param sfid
     * @return
     */
    public List<Salepro> selectBySfid(Integer sfid){
        return mapper.selectBySfid(sfid);
    }


    /**
     *
     * @param num
     * @param salefunnel
     * @param product
     * @return
     */
    public Integer insert(Integer num,Integer salefunnel,String product){
        return mapper.insert(num,salefunnel,product);
    }


}
