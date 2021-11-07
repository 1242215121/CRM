package com.study.model.services.aftersale;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.study.model.mapper.aftersale.HkxqMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class HkxqService {
    @Autowired
    HkxqMapper hkxqMapper;

    //根据回款编号查询回款详情
    public Map<String,Object> hkxqcx(String id){
        Map<String,Object> map=new HashMap<>();
        map.put("hkxqcx",hkxqMapper.hkxqcx(id));
        return map;
    }
}
