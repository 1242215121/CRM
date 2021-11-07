package com.study.controller.presale;

import com.study.model.mapper.presale.ClientMapper;
import com.study.model.pojo.presale.Client;
import com.study.model.services.presale.ClientService;
import com.study.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("client")
public class ClientController {
    @Autowired
    ClientService clientService;
    @RequestMapping("selectClient")
    public MyResult selectClient(@RequestBody Client client){
        return MyResult.SUCCESS_Object(clientService.selectClientByPage(client.getPageNo(),
                client.getSize(),client.getClientRule(),client.getClientName()));
    }
    @GetMapping
    public MyResult seClient(){
        return MyResult.SUCCESS_DATA(clientService.seClient());
    }
}
