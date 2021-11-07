package com.study.model.services.insale;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.model.mapper.insale.SaleorderMapper;
import com.study.model.pojo.insale.Saleorder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class SaleorderService {

    @Autowired private SaleorderMapper mapper;

    /**
     * 查询所有销售订单
     * @return
     */
    public PageInfo<Saleorder> selectAll(Integer no, Integer size){
        PageHelper.startPage(no,size);
        List<Saleorder> list = mapper.selectAll();
        return PageInfo.of(list);
    }

    /**
     * 多条件分页查询
     * @param no
     * @param size
     * @param id
     * @param name
     * @return
     */
    public PageInfo<Saleorder> selectMany(Integer no,Integer size,Integer id, String name){
        PageHelper.startPage(no,size);
        List<Saleorder> list = mapper.selectMany(id, name);
        return PageInfo.of(list);
    }

    /**
     * 新增销售订单
     * @param saleorder
     * @return
     */
    public Integer insert(Saleorder saleorder){
        return mapper.insert(saleorder);
    }

}
