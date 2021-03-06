package com.study.model.mapper.power;

import com.study.model.pojo.power.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {

    /**
     * 根据角色编号查询角色
     * @param roleid
     * @return
     */
    public Role selectByRoleId(Integer roleid);

    /**
     * 查询所有角色
     * @return
     */
    public List<Role> selectAll();
    /**
     * 根据角色编号查询角色 子查询查出模块
     * @param roleid
     * @return
     */
    public Role selectByRoleIdNogx(Integer roleid);

}
