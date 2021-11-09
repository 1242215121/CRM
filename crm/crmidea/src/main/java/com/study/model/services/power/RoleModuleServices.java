package com.study.model.services.power;

import com.study.model.mapper.power.RoleModuleMapper;
import com.study.model.pojo.power.RoleModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class RoleModuleServices {
    @Autowired
    RoleModuleMapper mapper;

    /**
     * 根据角色编号查询模块
     * @param roleid
     * @return
     */
    public List<RoleModule> selectByRoleId(Integer roleid){
        return mapper.selectByRoleId(roleid);
    }

    /**
     * 角色模块关联
     * @param roleModule
     * @return
     */
    public Integer insertRoleModule(RoleModule roleModule){
        return mapper.insertRoleModule(roleModule);
    }

    /**
     * 删除角色下的模块
     * @param roleid
     * @return
     */
    public Integer deleteByRoleId(Integer roleid){
        return mapper.deleteByRoleId(roleid);
    }

}
