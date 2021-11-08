package com.study.model.mapper.aftersale;

import com.study.model.pojo.insale.Saleorder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface DdhzMapper {
    //查询所有订单，或根据订单名称模糊查询
    public List<Saleorder> ddcx(String nr);

//    按订单编号查询订单信息
    public Saleorder ddcxid(Integer id);

//    修改订单,回款状态
    public void xgddzt(@Param("zt") String zt, @Param("id")  long id);
//    修改开票状态
    public void xgkpzt(@Param("zt") String zt, @Param("id")  long id);
}
