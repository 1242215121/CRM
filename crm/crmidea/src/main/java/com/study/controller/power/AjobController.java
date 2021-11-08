package com.study.controller.power;

import com.study.model.pojo.power.Ajob;
import com.study.model.pojo.power.Users;
import com.study.model.services.power.AjobServices;
import com.study.model.services.power.UsersServices;
import com.study.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ajob")
public class AjobController {
    @Autowired
    AjobServices ajobServices;
    @Autowired
    UsersServices usersServices;

    @GetMapping("all")
    public MyResult selectAll(){
        return MyResult.SUCCESS_DATA(ajobServices.selectAll());
    }

    @PostMapping("add")
    public MyResult insertAjob(@RequestBody Ajob ajob){
        //  新增前先判断该部门下是否有相同的职位 判断是否选中了上级部门
        try {
           Integer i= ajob.getDept().getDeptId();
           if(i==null){
               return MyResult.FAILURE("请选择部门!");
           }
        }catch (Exception e){
            e.printStackTrace();
            return MyResult.FAILURE("请选择部门!");
        }
        Ajob idnameAjob=ajobServices.selectByAjobName(ajob.getAjobName(),ajob.getDept().getDeptId());
        if(idnameAjob!=null){
            return MyResult.FAILURE("该部门下已有该职位，新增失败!");
        }else {
            ajobServices.insertAjob(ajob);
            return MyResult.SUCCESS;
        }
    }

    @PostMapping("update")
    public MyResult updateAjob(@RequestBody Ajob ajob){
        //  修改前先查询是否有相同的职位  是否选中了上级部门
       try {
           ajob.getDept().getDeptId();
           Integer i= ajob.getDept().getDeptId();
           if(i==null){
               return MyResult.FAILURE("请选择部门!");
           }
        }catch (Exception e){
           e.printStackTrace();
           return MyResult.FAILURE("请选择部门!");
       }
        Ajob idnameAjob=ajobServices.selectByAjobName(ajob.getAjobName(),ajob.getDept().getDeptId());
        if(idnameAjob!=null){
            return MyResult.FAILURE("该部门下已有该职位，修改失败!");
        }else {
            ajobServices.updateAjob(ajob);
            return MyResult.SUCCESS;
        }
    }

    @GetMapping("delete")
    public MyResult deleteAjob(@RequestParam Integer ajobid){
        //  删除前要判断该职位下是否有员工
        List<Users> usersList=usersServices.selectByAjobId(ajobid);

        if(usersList.size()>0&&usersList!=null){
            return MyResult.FAILURE("该职位下还有员工，删除失败！");
        }else {
            ajobServices.deleteByAjobId(ajobid);
            return MyResult.SUCCESS;
        }
    }
}
