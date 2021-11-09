package com.study.model.mapper.power;

import com.study.model.pojo.power.UsersRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UsersRoleMapper {

    /**
     *根据用户查询该用户的角色
     * @param usersid
     * @return
     */
    public List<UsersRole> selectByUsersId(Integer usersid);

    /**
     *根据角色查询该角色的用户
     * @param roleid
     * @return
     */
    public List<UsersRole> ByRoleId(Integer roleid);

    /**
     * 用户角色关联
     * @param usersRole
     */
    public Integer insertUsersRole(UsersRole usersRole);

    /**
     * 用于验证是否存在当前用户和角色的关联
     * @param usersRole
     * @return
     */
    public UsersRole byUsersRole(UsersRole usersRole);

    /**
     * 删除用户下的角色
     * @param usersid
     * @return
     */
    public Integer deleteByUsersId(Integer usersid);

    /**
     * 删除角色下的用户
     * @param roleid
     * @return
     */
    public Integer deleteByRoleId(Integer roleid);
}
