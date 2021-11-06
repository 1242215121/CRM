package com.study.model.services.insale;

import com.study.model.mapper.insale.SalefunnelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class SalefunnelService {

    @Autowired private SalefunnelMapper mapper;
}
