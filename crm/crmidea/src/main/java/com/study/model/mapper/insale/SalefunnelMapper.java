package com.study.model.mapper.insale;

import com.study.model.pojo.insale.Salefunnel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
/**
 * 销售机会
 */
public interface SalefunnelMapper {

    /**
     * 单表查询销售机会
     * @return
     */
    public List<Salefunnel> select();

    /**
     * 连接客户表，员工表，市场活动表，联系人表，查询销售机会
     * @return
     */
    public List<Salefunnel> selectAll();

    /**
     * 根据机会编号和机会名称查询所有
     * @param id
     * @param name
     * @return
     */
    public List<Salefunnel> selectMany(@Param("id") Integer id,@Param("name") String name);

    /**
     * 新增 销售机会
     * @return
     */
    public Integer insert(Salefunnel salefunnel);

    //获取新增
}
