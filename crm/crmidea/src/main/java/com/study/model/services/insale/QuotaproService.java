package com.study.model.services.insale;

import com.study.model.mapper.insale.QuotaproMapper;
import com.study.model.pojo.insale.Quotapro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class QuotaproService {

    @Autowired private QuotaproMapper mapper;

    /**
     * 根据报价单编号获取产品信息
     * @param qid
     * @return
     */
    public List<Quotapro> selectByQid(Integer qid){
        return mapper.selectByQid(qid);
    }
}
