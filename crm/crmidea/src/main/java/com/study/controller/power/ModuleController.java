package com.study.controller.power;

import com.study.model.services.power.ModuleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("module")
public class ModuleController {
    @Autowired
    ModuleServices services;
}
