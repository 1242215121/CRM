package com.study.model.mapper.presale;

import com.study.model.pojo.presale.Client;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClientMapper {
    public List<Client> selectClient(@Param("clientRule")String clientRule,@Param("clientName")String clientName);

    public List<Client> seClient();

    public Integer inClient(Client client);
}
