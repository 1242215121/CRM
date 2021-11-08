package com.study.controller.power;

import com.study.model.services.power.RoleServices;
import com.study.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("role")
public class RoleController {
    @Autowired
    RoleServices services;

    @GetMapping("all")
    public MyResult selectAll(){
        return MyResult.SUCCESS_DATA(services.selectAll());
    }
}
