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
}
