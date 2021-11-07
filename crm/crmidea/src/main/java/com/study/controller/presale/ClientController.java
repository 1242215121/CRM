package com.study.controller.presale;

import com.study.model.mapper.presale.ClientMapper;
import com.study.model.pojo.presale.Client;
import com.study.model.services.presale.ClientService;
import com.study.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("client")
public class ClientController {
    @Autowired
    ClientService clientService;
    @GetMapping
    public MyResult seClient(){
        return MyResult.SUCCESS_DATA(clientService.seClient());
    }
}
