package com.study.model.mapper.power;

import com.study.model.pojo.power.Module;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ModuleMapeer {
    /**
     * 根据编号查询模块
     * @param id
     * @return
     */
    public Module selectByModuleId(Integer id);

    /**
     * 根据附件编号查询模块
     * @param pid
     * @return
     */
    public List<Module> selectByModulePid(Integer pid);
}
