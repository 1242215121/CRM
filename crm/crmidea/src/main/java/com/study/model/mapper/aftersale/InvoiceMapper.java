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

//    确认办理
    public void qrbl(Invoice invoice);
//   订单开票金额修改
    public void ddkpjexg(double price,Integer id);
//    驳回
    public void bhbl(@Param("zt") Integer zt,@Param("id") Integer id,@Param("shr") Integer shr);
//    按期次查询开票记录
    public List<Invoice> kpqccx(Integer id);
//  开票新增
    public void kpxz(Invoice invoice);
//    按期次查询所有开票记录
    public List<Invoice> kpqccxall(long id);
}
