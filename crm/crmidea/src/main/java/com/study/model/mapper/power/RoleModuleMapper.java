package com.study.model.mapper.power;

import com.study.model.pojo.power.RoleModule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleModuleMapper {

    /**
     * 根据角色编号查询模块
     * @param roleid
     * @return
     */
    public List<RoleModule> selectByRoleId(Integer roleid);

}
