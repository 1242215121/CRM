package com.study.controller.power;

import com.study.model.pojo.power.Dept;
import com.study.model.pojo.power.Users;
import com.study.model.services.power.AjobServices;
import com.study.model.services.power.DeptServices;
import com.study.model.services.power.UsersServices;
import com.study.model.vojo.power.PageVo;
import com.study.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dept")
@Transactional(rollbackFor = Exception.class)
public class DeptController {
    @Autowired
    DeptServices deptServices;
    @Autowired
    UsersServices usersServices;
    @Autowired
    AjobServices ajobServices;

    @PostMapping("allpage")
    public MyResult selectAllDept(@RequestBody PageVo vo){
        return MyResult.SUCCESS_Object(deptServices.selectAllPage(vo));
    }

    @GetMapping("all")
    public MyResult selectAllDept(){
        return MyResult.SUCCESS_DATA(deptServices.selectAll());
    }

    @PostMapping("add")
    public MyResult insertDept(@RequestBody Dept dept){
        //        先根据部门名查询  如已存在就新增失败
        Dept namedept=deptServices.selectByDeptName(dept.getDeptName());
        if(namedept==null){
            deptServices.insertDept(dept);
            return MyResult.SUCCESS;
        }else{
            return MyResult.FAILURE("部门已存在!");
        }


    }

    @PostMapping("update")
    public MyResult updateDept(@RequestBody Dept dept){
        //        先根据部门名查询  如已存在就修改失败
        Dept namedept=deptServices.selectByDeptName(dept.getDeptName());
        if(namedept==null){
            deptServices.updateDept(dept);
            return MyResult.SUCCESS;
        }else{
            return MyResult.FAILURE("部门名称已存在!");
        }
    }

    @GetMapping("delete")
    public MyResult deleteDept(@RequestParam Integer did){
        //        删除部门时先判断部门下是否还有员工
        //        如果有不能进行删除

        List<Users> usersList=usersServices.selectByDeptId(did);

        if(usersList.size()>0&&usersList!=null){
            return MyResult.FAILURE("该部门下还有员工，删除失败！");
        }else {
            //    如果没有删除部门同时删除该部门下的职位
            try {
                deptServices.deleteDept(did);
                ajobServices.deleteByDeptId(did);
                int tept=10/0;
                return MyResult.SUCCESS;
            }catch (Exception e){
                e.printStackTrace();
                return MyResult.FAILURE("删除时失败，请联系管理员检查");
            }
        }

    }
}
