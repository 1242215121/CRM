package com.study.model.pojo.power;

import com.study.model.pojo.power.Role;
/**
 * 用户角色
 */
public class UsersRole {
    private Integer id;
    private Users users;//用户
    private Role role;//角色

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
