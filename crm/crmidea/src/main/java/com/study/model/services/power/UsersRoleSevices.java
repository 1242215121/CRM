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

    /**
     * 用于验证是否存在当前用户和角色的关联
     * @param usersRole
     * @return
     */
    public UsersRole byUsersRole(UsersRole usersRole){
        return mapper.byUsersRole(usersRole);
    }
    /**
     * 用户角色关联
     * @param usersRole
     */
    public Integer insertUsersRole(UsersRole usersRole){
        try {
            mapper.insertUsersRole(usersRole);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 删除用户下关联的角色
     * @param usersid
     * @return
     */
    public Integer deleteByUsersId(Integer usersid){
        try {
            mapper.deleteByUsersId(usersid);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 删除角色下关联的用户
     * @param roleid
     * @return
     */
    public Integer deleteByRoleId(Integer roleid){
        try {
            mapper.deleteByRoleId(roleid);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }
}
