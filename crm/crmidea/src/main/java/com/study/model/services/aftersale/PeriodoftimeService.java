package com.study.model.services.aftersale;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.study.model.mapper.aftersale.PeriodoftimeMapper;
import com.study.model.pojo.aftersale.Periodoftime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class PeriodoftimeService {
    @Autowired
    PeriodoftimeMapper periodoftimeMapper;

    //根据订单编号查询计划期次
    public Map<String,Object> qcddcx(Integer id){
        Map<String,Object> map=new HashMap<>();
        map.put("qcddcx",periodoftimeMapper.qcddcx(id));
        return map;
    }

    //新增期次
    public int qcxz(Periodoftime periodoftime){
        try{
            periodoftimeMapper.qcxz(periodoftime);
            return 0;
        }catch (Exception e){
            return 1;
        }
    }

    //根据订单名称模糊查询计划期次，或显示所有数据
    public Map<String,Object> qccx(Integer pageNo,Integer size,String nr){
        Map<String,Object> map=new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("qccx",periodoftimeMapper.qccx(nr));
        map.put("total",page.getTotal());
        return map;
    }
}
