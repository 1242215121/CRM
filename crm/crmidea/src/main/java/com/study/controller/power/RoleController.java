package com.study.controller.power;

import com.study.model.pojo.power.RoleModule;
import com.study.model.pojo.power.UsersRole;
import com.study.model.services.power.RoleModuleServices;
import com.study.model.services.power.RoleServices;
import com.study.model.services.power.UsersRoleSevices;
import com.study.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("role")
public class RoleController {
    @Autowired
    RoleServices services;
    @Autowired
    UsersRoleSevices ues;
    @Autowired
    RoleModuleServices rms;

    @GetMapping("all")
    public MyResult selectAll(){
        return MyResult.SUCCESS_DATA(services.selectAll());
    }

    @PostMapping("usersRole")
    public MyResult usersRole(UsersRole usersRole){
        //角色和用户关联
        ues.insertUsersRole(usersRole);
        return MyResult.SUCCESS;
    }

    @PostMapping("roleModule")
    public MyResult roleModule(RoleModule roleModule){
        //用户和模块关联
        rms.insertRoleModule(roleModule);
        return MyResult.SUCCESS;
    }
}
