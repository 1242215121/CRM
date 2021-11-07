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
}
