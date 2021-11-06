package com.study.model.services.power;

import com.study.model.mapper.power.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServices {
    @Autowired
    RoleMapper mapper;
}
