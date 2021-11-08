package com.study.model.services.aftersale;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.study.model.mapper.aftersale.DdhzMapper;
import com.study.model.mapper.aftersale.PeriodoftimeMapper;
import com.study.model.mapper.aftersale.ReceivableMapper;
import com.study.model.pojo.aftersale.Periodoftime;
import com.study.model.pojo.aftersale.Receivable;
import com.study.model.pojo.insale.Saleorder;
import com.study.model.pojo.power.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ReceivableService {
    @Autowired
    ReceivableMapper receivableMapper;

    @Autowired
    PeriodoftimeMapper periodoftimeMapper;

    @Autowired
    DdhzMapper ddhzMapper;

    //根据回款状态,回款编号，用户人查询回款记录
    public Map<String,Object> hkcx(Integer pageNo,Integer size,Integer zt,String nr){
        System.out.println(zt);
        Map<String,Object> map=new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("hkcx",receivableMapper.receivablecx(zt,nr));
        map.put("total",page.getTotal());
        return map;

    }

    //根据订单名称查询回款记录
    public Map<String,Object> hkjlcx(Integer pageNo,Integer size,String nr){
        Map<String,Object> map=new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("hkjlcx",receivableMapper.hkjlcx(nr));
        map.put("total",page.getTotal());
        return map;

    }

    //按期次查询没有被驳回的回款记录
    public Map<String,Object> hkcxqcid(Integer id){
        Map<String,Object> map=new HashMap<>();
        map.put("hkjlcx",receivableMapper.hkcxqcid(id));
        return map;

    }

    //新增回款记录
    public int hkxz(Map<String,Object> map){
        try{
            ObjectMapper mapper = new ObjectMapper();
            Receivable receivable = mapper.convertValue(map.get("receivable"), Receivable.class);
            receivableMapper.hkxz(receivable);
            return 0;
        }catch (Exception e){

            return 1;
        }

    }

    //回款确认
    public void qrhk(Map<String,Object> map){
        ObjectMapper mapper = new ObjectMapper();
        List<Object> list = (List<Object>)map.get("hk");
        Users emp = mapper.convertValue(map.get("emp"), Users.class);
        for (Object o : list) {
            Receivable receivable = mapper.convertValue(o, Receivable.class);
            receivableMapper.receivablexgzt(1,receivable.getReceivableId(),emp.getUsersId());
            receivableMapper.ddhkjexg(receivable.getReceivablePrice(),receivable.getReceivableDdid().getSoId());
            periodoftimeMapper.qchkje(receivable.getReceivablePrice(),receivable.getReceivableQcid().getPeriodoftimeId());
            Periodoftime qcidcx = periodoftimeMapper.qcidcx(receivable.getReceivableQcid().getPeriodoftimeId());
            if(qcidcx.getPeriodoftimeSjprice()!=0){
                if(qcidcx.getPeriodoftimePrice()>qcidcx.getPeriodoftimeSjprice()){
                    periodoftimeMapper.qcztxg(2,qcidcx.getPeriodoftimeId());
                }else if(qcidcx.getPeriodoftimePrice()==qcidcx.getPeriodoftimeSjprice()){
                    periodoftimeMapper.qcztxg(1,qcidcx.getPeriodoftimeId());
                }
            }
            Saleorder ddcxid = ddhzMapper.ddcxid(receivable.getReceivableDdid().getSoId());
            if(ddcxid.getSoPay().doubleValue()==0){
                ddhzMapper.xgddzt("已全部付款",ddcxid.getSoId());
            }else{
                if(ddcxid.getSoPay().doubleValue()>0){
                    ddhzMapper.xgddzt("部分付款",ddcxid.getSoId());
                }
            }
        }
    }

    //回款驳回
    public void bhhk(Map<String,Object> map){
        ObjectMapper mapper = new ObjectMapper();
        List<Object> list = (List<Object>)map.get("hk");
        Users emp = mapper.convertValue(map.get("emp"), Users.class);
        for (Object o : list) {
            Receivable receivable = mapper.convertValue(o, Receivable.class);
            receivableMapper.receivablexgzt(2,receivable.getReceivableId(),emp.getUsersId());
        }
    }
}
