package com.study.model.mapper.aftersale;

import com.study.model.pojo.aftersale.Receivable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReceivableMapper {
    //根据回款状态,回款编号，用户人查询回款记录
    public List<Receivable> receivablecx(@Param("zt") Integer zt,@Param("nr")  String nr);
    //修改状态
    public void receivablexgzt(@Param("zt") Integer zt,@Param("id") String id,@Param("usersId") Integer usersId);
    //根据回款状态,回款编号，用户人查询回款记录
    public List<Receivable> hkjlcx(@Param("nr")  String nr);

    public void ddhkjexg(@Param("price") double price,@Param("id")  Integer id);

//    按期次查询没有被驳回的回款记录
    public List<Receivable> hkcxqcid(Integer id);
    //回款新增
    public void hkxz(Receivable receivable);
    //按期次查询所有回款记录
    public List<Receivable> hkqccxall(long id);
}
