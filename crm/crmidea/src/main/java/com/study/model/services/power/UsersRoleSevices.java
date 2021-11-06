package com.study.model.services.power;

import com.study.model.mapper.power.UsersRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class UsersRoleSevices {
    @Autowired
    UsersRoleMapper mapper;
}
