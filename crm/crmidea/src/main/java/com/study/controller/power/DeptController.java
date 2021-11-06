package com.study.controller.power;

import com.study.model.services.power.DeptServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dept")
public class DeptController {
    @Autowired
    DeptServices services;
}
