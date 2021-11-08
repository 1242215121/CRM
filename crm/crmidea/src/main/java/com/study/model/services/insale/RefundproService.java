package com.study.model.services.insale;

import com.study.model.mapper.insale.RefundproMapper;
import com.study.model.pojo.insale.Refundpro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class RefundproService {

    @Autowired private RefundproMapper mapper;

    /**
     * 根据退货单编号查询产品信息
     * @param rid
     * @return
     */
    public List<Refundpro> selectByRid(Integer rid){
        return mapper.selectByRid(rid);
    }
}
