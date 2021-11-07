package com.study.model.mapper.aftersale;

import com.study.model.pojo.aftersale.Invoice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InvoiceMapper {
    //按订单模糊查询开票记录
    public List<Invoice> kpcx(String nr);
}
