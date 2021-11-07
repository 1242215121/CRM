package com.study.controller.power;

import com.study.model.pojo.power.Users;
import com.study.model.services.power.UsersRoleSevices;
import com.study.model.services.power.UsersServices;
import com.study.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UsersController {
    @Autowired
    UsersServices usersServices;
    @Autowired
    UsersRoleSevices usersRoleSevices;

    @PostMapping("login")
    public MyResult selectByUserName(@RequestParam(value = "usersName") String usersName,
                                     @RequestParam(value = "usersPwd") String usersPwd){
        //根据用户名查询
        Users users=usersServices.selectByUsersName(usersName);
        if(users==null){
            //如果没有查询到用户
            return MyResult.FAILURE("用户名错误！！");
        }else{
            //查询到用户  验证密码的正确性
            if(users.getUsersPwd().equals(usersPwd)){
                //密码正确 判断用户状态是否可用
                if(users.getState()!=1){
                    return MyResult.FAILURE("该用户已停用！！");
                }
                //正常就返回实体
                return MyResult.SUCCESS_Object(users);
            }else {
                //密码错误
                return MyResult.FAILURE("密码错误！！");
            }
        }

    }

    @RequestMapping("ajobId")
    public MyResult selectByAjobId(@RequestParam(value = "ajobid",defaultValue = "3") Integer ajobid){
        return MyResult.SUCCESS_DATA(usersServices.selectByAjobId(ajobid));
    }

    @GetMapping("usersRole")
    public MyResult selectUsersRoleByUserId(@RequestParam(value = "uid",defaultValue = "1") Integer uid){
        return MyResult.SUCCESS_DATA(usersRoleSevices.selectByUsersId(uid));
    }

    @GetMapping
    public MyResult selectAlls(){
        return MyResult.SUCCESS_DATA(usersServices.selectAlls());
    }
}
