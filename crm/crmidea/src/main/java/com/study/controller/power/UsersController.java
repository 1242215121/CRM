package com.study.controller.power;

import com.study.model.pojo.power.Users;
import com.study.model.services.power.UsersServices;
import com.study.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UsersController {
    @Autowired
    UsersServices services;

    @PostMapping("login")
    public MyResult selectByUserName(@RequestParam(value = "usersName") String usersName,
                                     @RequestParam(value = "usersPwd") String usersPwd){
        //根据用户名查询
        Users users=services.selectByUsersName(usersName);
        if(users==null){
            //如果没有查询到用户
            return MyResult.FAILURE("用户名错误！！");
        }else{
            //查询到用户  验证密码的正确性
            if(users.getUsersPwd().equals(usersPwd)){
                //密码正确 返回用户对象
                return MyResult.SUCCESS_Object(users);
            }else {
                //密码错误
                return MyResult.FAILURE("密码错误！！");
            }
        }

    }
}
