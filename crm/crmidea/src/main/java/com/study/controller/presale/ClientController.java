package com.study.controller.presale;

import com.study.model.mapper.presale.ClientMapper;
import com.study.model.pojo.presale.Client;
import com.study.model.services.presale.ClientService;
import com.study.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("client")
public class ClientController {
    MyResult myResult =new MyResult();
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
    @PostMapping("inClient")
    public MyResult inClient(@RequestBody Client client){
        System.out.println(client);
        Integer a = clientService.inClient(client);
        if(a>0){
            myResult.setCode(1);
            System.err.println("新增成功");
            return MyResult.SUCCESS;
        }
        return MyResult.FAILURE("新增失败");
    }
}
