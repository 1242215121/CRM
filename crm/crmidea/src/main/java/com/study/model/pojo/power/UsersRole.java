package com.study.model.pojo.power;

import javax.persistence.*;
import java.util.Objects;

public class UsersRole {
    private Integer id;
    private Users users;
    private Role rloe;

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

    public Role getRloe() {
        return rloe;
    }

    public void setRloe(Role rloe) {
        this.rloe = rloe;
    }
}
