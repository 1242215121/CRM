package com.study.model.services.power;

import com.study.model.mapper.power.UsersRoleMapper;
import com.study.model.pojo.power.UsersRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UsersRoleSevices {
    @Autowired
    UsersRoleMapper mapper;

    /**
     *根据用户查询该用户的角色
     * @param usersid
     * @return
     */
    public List<UsersRole> selectByUsersId(Integer usersid){
        return mapper.selectByUsersId(usersid);
    }

    /**
     *根据角色查询该角色的用户
     * @param roleid
     * @return
     */
    public List<UsersRole> selectByRoleId(Integer roleid){
        return mapper.ByRoleId(roleid);
    }
}
