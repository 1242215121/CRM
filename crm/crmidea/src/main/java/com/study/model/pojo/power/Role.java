package com.study.model.pojo.power;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

public class Role {
    private Integer roleId;
    private String roleName;
    private String roleDesc;
    private Integer roleStatus;
    private List<UsersRole> usersRole;
    private List<RoleModule> roleModule;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public Integer getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(Integer roleStatus) {
        this.roleStatus = roleStatus;
    }

    public List<UsersRole> getUsersRole() {
        return usersRole;
    }

    public void setUsersRole(List<UsersRole> usersRole) {
        this.usersRole = usersRole;
    }

    public List<RoleModule> getRoleModule() {
        return roleModule;
    }

    public void setRoleModule(List<RoleModule> roleModule) {
        this.roleModule = roleModule;
    }
}
