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
     * 根据部门名称查询 用于修改验证
     * @param deptname
     * @return
     */
    public Dept selectByDeptName(String deptname);
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

    /**
     * 修改部门
     * @param dept
     * @return
     */
    public Integer updateDept(Dept dept);

    /**
     * 根据部门主键删除
     * @param deptid
     * @return
     */
    public Integer deleteDept(Integer deptid);
}
