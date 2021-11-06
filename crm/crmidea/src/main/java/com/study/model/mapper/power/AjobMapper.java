package com.study.model.mapper.power;

import com.study.model.pojo.power.Ajob;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AjobMapper {

    /**
     * 查询所有职位
     * @return
     */
    public List<Ajob> selectAll();

    /**
     * 根据职位编号查询职位
     * @return
     */
    public Ajob selectByAjobId(Integer jobid);
}
