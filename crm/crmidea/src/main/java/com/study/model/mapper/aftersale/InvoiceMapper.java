package com.study.model.mapper.aftersale;

import com.study.model.pojo.aftersale.Invoice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface InvoiceMapper {
    //按订单模糊查询开票记录
    public List<Invoice> kpcx(String nr);

    //按订单模糊查询开票记录
    public List<Invoice> kpblcx(@Param("zt") Integer zt,@Param("nr") String nr);

    public void qrbl(Invoice invoice);

    public void ddkpjexg(double price,Integer id);

    public void bhbl(@Param("zt") Integer zt,@Param("id") Integer id);
}
