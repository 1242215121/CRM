package com.study.model.mapper.presale;


import com.study.model.pojo.presale.Activity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActivityMapper {
    public List<Activity> seActivity();
}
