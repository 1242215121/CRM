package com.study.model.mapper.power;

import com.study.model.pojo.power.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UsersMapper {

    /**
     * 查询所有用户
     * @return
     */
    public List<Users> selectAll();

    /**
     * 根据用户名查询用户
     * @param name  用户名
     * @return
     */
    public Users selectByUsersName(String name);

    /**
     * 根据职位编号查询用户
     * @param jobid  职位编号
     * @return
     */
    public List<Users> selectByAjobId(Integer jobid);

    /**
     * 根据部门编号查询用户
     * @param deptid
     * @return
     */
    public List<Users> selectByDeptId(Integer deptid);

}
