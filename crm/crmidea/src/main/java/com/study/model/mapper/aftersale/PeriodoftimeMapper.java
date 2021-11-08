package com.study.model.mapper.aftersale;

import com.study.model.pojo.aftersale.Periodoftime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PeriodoftimeMapper {
//    按订单编号查询期次
    public List<PeriodoftimeMapper> qcddcx(Integer id);

//    期次新增
    public void qcxz(Periodoftime periodoftime);

//    按订单名称模糊查询
    public List<PeriodoftimeMapper> qccx(String nr);

//    修改实际回款金额
    public void qchkje(@Param("price") double price, @Param("id")  long id);

    //    修改开票金额
    public void qckpje(@Param("price") double price, @Param("id")  long id);
}
