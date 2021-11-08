package com.study.controller.power;

import com.study.model.pojo.power.Users;
import com.study.model.services.power.UsersRoleSevices;
import com.study.model.services.power.UsersServices;
import com.study.model.vojo.power.UsersVo;
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

    @PostMapping("allpage")
    public  MyResult selectAllPage(@RequestBody UsersVo vo){
        System.out.println(vo.toString()+":前台传来的");
        return MyResult.SUCCESS_Object(usersServices.selectAll(vo));
    }

    @GetMapping
    public MyResult selectAlls(){
        return MyResult.SUCCESS_DATA(usersServices.selectAlls());
    }

    @GetMapping("byusersid")
    public MyResult selectByUsersId(Integer usersid){
        return MyResult.SUCCESS_Object(usersServices.selectByUsersId(usersid));
    }

    /**
     * wjl  新增用户
     * @param users
     * @return
     */
    @PostMapping("add")
    public MyResult addUsers(@RequestBody Users users){
        //先根据用户名查询  如果已存在不新增
      Users uname=usersServices.selectByUsersName(users.getUsersName());
      if(uname!=null){
          return MyResult.FAILURE("该用户名已被注册!");
      }else{
          if(usersServices.insertUsers(users)!=-1){
              return MyResult.SUCCESS;
          }else{
              return MyResult.FAILURE("新增用户失败!");
          }
      }
    }

    /**
     * wjl  修改用户信息
     * @param users
     * @return
     */
    @PostMapping("update")
    public MyResult updateUsers(@RequestBody Users users){

            if(usersServices.updateUsers(users)!=-1){
                return MyResult.SUCCESS;
            }else{
                return MyResult.FAILURE("修改用户信息失败!");
            }

    }

    @GetMapping("updateState")
    public MyResult updateUsersState(@RequestParam(value = "usersid") Integer usersid,@RequestParam(value = "state") Integer state){

        if(usersServices.updateUsersState(usersid,state)!=-1){
            return MyResult.SUCCESS;
        }else{
            return MyResult.FAILURE("修改用户状态失败!");
        }
    }
}
