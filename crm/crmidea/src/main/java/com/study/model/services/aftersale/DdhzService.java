package com.study.model.services.aftersale;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.study.model.mapper.aftersale.DdhzMapper;
import com.study.model.mapper.insale.SaleorderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class DdhzService {
    @Autowired
    DdhzMapper ddhzMapper;

    //根据订单名称模糊查询订单信息，或显示所有数据
    public Map<String,Object> ddcx(Integer pageNo, Integer size, String nr){
        Map<String,Object> map=new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("ddcx",ddhzMapper.ddcx(nr));
        map.put("total",page.getTotal());
        return map;
    }
}
