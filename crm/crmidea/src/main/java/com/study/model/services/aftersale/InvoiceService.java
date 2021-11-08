package com.study.model.services.aftersale;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.study.model.mapper.aftersale.InvoiceMapper;
import com.study.model.mapper.aftersale.PeriodoftimeMapper;
import com.study.model.pojo.aftersale.Invoice;
import com.study.model.pojo.aftersale.Receivable;
import com.study.model.pojo.power.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class InvoiceService {
    @Autowired
    InvoiceMapper invoiceMapper;

    @Autowired
    PeriodoftimeMapper periodoftimeMapper;

    //根据订单名称模糊查询开票记录，或显示所有数据
    public Map<String,Object> kpcx(Integer pageNo, Integer size, String nr){
        Map<String,Object> map=new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("kpcx",invoiceMapper.kpcx(nr));
        map.put("total",page.getTotal());
        return map;
    }


    //根据申请名称模糊查询开票记录
    public Map<String,Object> kpblcx(Integer pageNo, Integer size,Integer zt, String nr){
        Map<String,Object> map=new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("kpblcx",invoiceMapper.kpblcx(zt,nr));
        map.put("total",page.getTotal());
        return map;
    }


    //开票办理
    public int qrbl(Map<String,Object> map){
        try{
            ObjectMapper mapper = new ObjectMapper();
            Invoice kpjl = mapper.convertValue(map.get("kpjl"), Invoice.class);
            invoiceMapper.qrbl(kpjl);
            invoiceMapper.ddkpjexg(kpjl.getInvoicePrice(),kpjl.getInvoiceDdid().getSoId());
            periodoftimeMapper.qckpje(kpjl.getInvoicePrice(),kpjl.getInvoiceQcid().getPeriodoftimeId());
            return 0;
        }catch (Exception e){
            return 1;
        }
    }

    //回款驳回
    public int bhbl(Map<String,Object> map){
        Integer id=(Integer)map.get("id");
        System.out.println(id);
        try{
            invoiceMapper.bhbl(2,id);

            return 0;
        }catch (Exception e){
            return 1;
        }

    }
}
