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

    /**
     * 角色模块关联
     * @param roleModule
     * @return
     */
    public Integer insertRoleModule(RoleModule roleModule);

    /**
     * 删除角色下的模块
     * @param roleid
     * @return
     */
    public Integer deleteByRoleId(Integer roleid);

}
