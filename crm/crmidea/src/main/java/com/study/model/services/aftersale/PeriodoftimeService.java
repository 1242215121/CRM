package com.study.model.services.aftersale;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.study.model.mapper.aftersale.InvoiceMapper;
import com.study.model.mapper.aftersale.PeriodoftimeMapper;
import com.study.model.mapper.aftersale.ReceivableMapper;
import com.study.model.pojo.aftersale.Invoice;
import com.study.model.pojo.aftersale.Periodoftime;
import com.study.model.pojo.aftersale.Receivable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PeriodoftimeService {
    @Autowired
    PeriodoftimeMapper periodoftimeMapper;
    @Autowired
    InvoiceMapper invoiceMapper;
    @Autowired
    ReceivableMapper receivableMapper;

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

    public int del(Periodoftime periodoftime){
        List<Receivable> hkqccxall = receivableMapper.hkqccxall(periodoftime.getPeriodoftimeId());
        List<Invoice> kpqccxall = invoiceMapper.kpqccxall(periodoftime.getPeriodoftimeId());
        if(hkqccxall.size()<=0 && kpqccxall.size()<=0){
            List<Periodoftime> qcddcx = periodoftimeMapper.qcddcx(periodoftime.getPeriodoftimeDdid().getSoId());
            int a = Integer.parseInt(hqsz(periodoftime.getPeriodoftimeName()));
            for (Periodoftime qcddcx1 : qcddcx) {
                int b= Integer.parseInt(hqsz(qcddcx1.getPeriodoftimeName()));
                if(a<b){
                    String name="第"+(b-1)+"期";
                    periodoftimeMapper.qcnamexg(name,qcddcx1.getPeriodoftimeId());
                }
            }
            periodoftimeMapper.qcdel(periodoftime.getPeriodoftimeId());
            return 0;
        }else{
            return 1;
        }

    }

//    从字符串截取数字
    public String hqsz(String str){
        str=str.trim();
        String str2="";
        if(str != null && !"".equals(str)){
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)>=48 && str.charAt(i)<=57){
                    str2+=str.charAt(i);
                }
            }

        }
        return str2;
    }
}
