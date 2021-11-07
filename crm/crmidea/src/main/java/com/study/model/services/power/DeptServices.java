package com.study.model.services.power;

import com.study.model.mapper.power.DeptMapper;
import com.study.model.pojo.power.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class DeptServices {
    @Autowired
    DeptMapper mapper;

    /**
     * 根据部门编号查询
     * @return
     */
    public Dept selectByDeptId(Integer deptid){
        return mapper.selectByDeptId(deptid);
    }

    /**
     * 查询所有部门
     * @return
     */
    public List<Dept> selectAll(){
        return mapper.selectAll();
    }

    /**
     * 根据部门编号查询 不查询关系字段
     * @param deptid
     * @return
     */
    public Dept selectByDeptIdNoUsers(Integer deptid){
        return mapper.selectByDeptIdNoUsers(deptid);
    }


    /**
     * 根据部门名称查询 用于修改验证
     * @param deptname
     * @return
     */
    public Dept selectByDeptName(String deptname){
        return mapper.selectByDeptName(deptname);
    }

    /**
     * 新增部门
     * @param dept
     * @return
     */
    public Integer insertDept(Dept dept){
        try {
            mapper.insertDept(dept);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 修改部门
     * @param dept
     * @return
     */
    public Integer updateDept(Dept dept){
        try {
            mapper.updateDept(dept);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 根据部门主键删除
     * @param deptid
     * @return
     */
    public Integer deleteDept(Integer deptid){
        try {
            mapper.deleteDept(deptid);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }
}
