package com.study.model.mapper.insale;

import com.study.model.pojo.insale.Refundpro;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RefundproMapper {

    /**
     * 根据退货单编号查询产品信息
     * @param rid
     * @return
     */
    public List<Refundpro> selectByRid(Integer rid);
}
