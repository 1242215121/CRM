package com.study.model.services.power;

import com.study.model.mapper.power.RoleMapper;
import com.study.model.pojo.power.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServices {
    @Autowired
    RoleMapper mapper;

    /**
     * 根据角色编号查询角色
     * @param roleid
     * @return
     */
    public Role selectByRoleId(Integer roleid){
        return mapper.selectByRoleId(roleid);
    }

    /**
     * 查询所有角色
     * @return
     */
    public List<Role> selectAll(){
        return mapper.selectAll();
    }

    /**
     * 根据角色编号查询角色 子查询查出模块
     * @param roleid
     * @return
     */
    public Role selectByRoleIdNogx(Integer roleid){
        return mapper.selectByRoleIdNogx(roleid);
    }
}
