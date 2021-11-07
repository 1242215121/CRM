package com.study.model.pojo.power;

import javax.persistence.*;
import java.util.Objects;

/**
 * 角色模块
 */
public class RoleModule {
    private Integer id;
    private Role role;//角色
    private Module module;//模块

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}
