package com.study.model.mapper.insale;

import com.study.model.pojo.insale.Quotations;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
/**
 * 报价单
 */
public interface QuotationsMapper {

    /**
     * 关联销售机会查询所有报价单
     * @return
     */
    public List<Quotations> selectAll();

    /**
     * 多条件查询
     * @param id
     * @param name
     * @return
     */
    public List<Quotations> selectMany(@Param("id") Integer id,@Param("name") String name);

    /**
     * 根据报价单编号修改状态
     * @param qid
     * @return
     */
    public Integer updateStage(Integer qid);

    /**
     * 根据报价单编号获取报价单信息
     * @param qid
     * @return
     */
    public Quotations selectOwn(Integer qid);

    /**
     * 新增报价单
     * @param quotations
     * @return
     */
    public Integer insert(Quotations quotations);
}
