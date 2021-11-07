package com.study.model.services.aftersale;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.study.model.mapper.aftersale.InvoiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class InvoiceService {
    @Autowired
    InvoiceMapper invoiceMapper;

    //根据订单名称模糊查询开票记录，或显示所有数据
    public Map<String,Object> qccx(Integer pageNo, Integer size, String nr){
        Map<String,Object> map=new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("kpcx",invoiceMapper.kpcx(nr));
        map.put("total",page.getTotal());
        return map;
    }
}
