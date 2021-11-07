package com.study.model.mapper.presale;

import com.study.model.pojo.presale.Client;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClientMapper {
    public List<Client> seClient();
}
