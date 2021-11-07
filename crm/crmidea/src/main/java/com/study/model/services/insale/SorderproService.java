package com.study.model.services.insale;

import com.study.model.mapper.insale.SorderproMapper;
import com.study.model.pojo.insale.Sorderpro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class SorderproService {

    @Autowired private SorderproMapper mapper;

    /**
     * 根据销售订单查询产品信息
     * @param soid
     * @return
     */
    public List<Sorderpro> selectBySoid(Integer soid){
        return mapper.selectBySoid(soid);
    }
}
