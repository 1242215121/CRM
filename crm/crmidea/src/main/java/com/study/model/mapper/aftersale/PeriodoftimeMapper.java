package com.study.model.mapper.aftersale;

import com.study.model.pojo.aftersale.Periodoftime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PeriodoftimeMapper {
//    按订单编号查询期次
    public List<Periodoftime> qcddcx(Integer id);

//    期次新增
    public void qcxz(Periodoftime periodoftime);

//    按订单名称模糊查询
    public List<PeriodoftimeMapper> qccx(String nr);

//    修改实际回款金额
    public void qchkje(@Param("price") double price, @Param("id")  long id);

    //    修改开票金额
    public void qckpje(@Param("price") double price, @Param("id")  long id);

//    修改期次状态
    public void qcztxg(@Param("zt") Integer zt,@Param("id")  long id);
//    按期次编号查询
    public Periodoftime qcidcx(long id);
//    删除期次
    public void qcdel(long id);
    //    修改期次名称
    public void qcnamexg(@Param("name") String name,@Param("id") long id);
}
