package com.study.model.mapper.insale;

import com.study.model.pojo.insale.Salefunnel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SalefunnelMapper {

    public List<Salefunnel> selectAll();
}
