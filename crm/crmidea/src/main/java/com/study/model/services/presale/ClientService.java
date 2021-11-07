package com.study.model.services.presale;

import com.study.model.mapper.presale.ClientMapper;
import com.study.model.pojo.presale.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ClientService {
    @Autowired
    ClientMapper clientMapper;
    public List<Client> seClient(){
        return clientMapper.seClient();
    }
}
