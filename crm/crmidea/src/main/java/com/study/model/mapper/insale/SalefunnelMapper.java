package com.study.model.mapper.insale;

import com.study.model.pojo.insale.Salefunnel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
/**
 * 销售机会
 */
public interface SalefunnelMapper {

    /**
     * 连接客户表，员工表，市场活动表，联系人表，查询销售机会
     * @return
     */
    public List<Salefunnel> selectAll();

    /**
     * 新增 销售机会
     * @return
     */
    public Integer insert(Salefunnel salefunnel);
}
