package com.study.model.services.power;

import com.study.model.mapper.power.RoleModuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class RoleModuleServices {
    @Autowired
    RoleModuleMapper mapper;
}
