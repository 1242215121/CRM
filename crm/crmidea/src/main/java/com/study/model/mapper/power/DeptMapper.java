package com.study.model.mapper.power;

import com.study.model.pojo.power.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {
    /**
     * 根据部门编号查询
     * @return
     */
    public Dept selectByDeptId(Integer deptid);

    /**
     * 根据部门编号查询 不查询关系字段
     * @param deptid
     * @return
     */
    public Dept selectByDeptIdNoUsers(Integer deptid);
    /**
     * 查询所有部门
     * @return
     */
    public List<Dept> selectAll();

    /**
     * 新增部门
     * @param dept
     * @return
     */
    public Integer insertDept(Dept dept);
}
