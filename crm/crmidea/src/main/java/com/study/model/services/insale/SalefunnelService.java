package com.study.model.services.insale;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.model.mapper.insale.SalefunnelMapper;
import com.study.model.pojo.insale.Salefunnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class SalefunnelService {

    @Autowired private SalefunnelMapper mapper;

    /**
     * 连接客户表，员工表，市场活动表，联系人表，查询销售机会
     * @return
     */
    public PageInfo<Salefunnel> selectAll(Integer no,Integer size){
        PageHelper.startPage(no,size);
        List<Salefunnel> list = mapper.selectAll();
        return PageInfo.of(list);
    }

    /**
     * 根据机会编号和机会名称查询所有
     * @param id
     * @param name
     * @return
     */
    public PageInfo<Salefunnel> selectMany(Integer no,Integer size,Integer id, String name){
        PageHelper.startPage(no,size);
        List<Salefunnel> list = mapper.selectMany(id, name);
        return PageInfo.of(list);
    }


    /**
     * 新增 销售机会
     * @param salefunnel
     * @return
     */
    public Integer insert(Salefunnel salefunnel){
        return mapper.insert(salefunnel);
    }
}
