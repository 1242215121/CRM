package com.study.model.services.insale;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.model.mapper.insale.QuotationsMapper;
import com.study.model.pojo.insale.Quotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class QuotationsService {

    @Autowired private QuotationsMapper mapper;

    /**
     * 关联销售机会查询所有报价单
     * @return
     */
    public PageInfo<Quotations> selectAll(Integer no,Integer size){
        PageHelper.startPage(no,size);
        List<Quotations> list = mapper.selectAll();
        return PageInfo.of(list);
    }

    /**
     * 多条件分页查询
     * @param no
     * @param size
     * @param id
     * @param name
     * @return
     */
    public PageInfo<Quotations> selectMany(Integer no,Integer size,Integer id, String name){
        PageHelper.startPage(no,size);
        List<Quotations> list = mapper.selectMany(id, name);
        return PageInfo.of(list);
    }

    /**
     * 根据报价单编号修改状态
     * @param qid
     * @return
     */
    public Integer updateStage(Integer qid){
       return mapper.updateStage(qid);
    }

    /**
     * 新增报价单
     * @param quotations
     * @return
     */
    public Integer insert(Quotations quotations){
        return mapper.insert(quotations);
    }

}
