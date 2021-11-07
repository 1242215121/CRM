package com.study.model.mapper.insale;

import com.study.model.pojo.insale.Quotapro;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface QuotaproMapper {

    /**
     * 根据报价单编号获取产品信息
     * @param qid
     * @return
     */
    public List<Quotapro> selectByQid(Integer qid);
}
