package com.study.model.services.insale;

import com.study.model.mapper.insale.SaleproMapper;
import com.study.model.pojo.insale.Salepro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
/**
 * 销售机会和产品中间表
 */
public class SaleproService {

    @Autowired private SaleproMapper mapper;

    /**
     * 根据销售机会编号查询产品信息
     * @param sfid
     * @return
     */
    public List<Salepro> selectBySfid(Integer sfid){
        return mapper.selectBySfid(sfid);
    }


}
