package com.study.model.mapper.power;

import com.study.model.pojo.power.Users;
import com.study.model.vojo.power.UsersVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface UsersMapper {

    /**
     * 查询所有用户
     * @return
     */
    public List<Users> selectAll(UsersVo vo);

    /**
     * 查询所有用户
     * @return
     */
    public List<Users> selectAlls();

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

    /**
     * 根据用户编号查询
     * @param uid
     * @return
     */
    public Users selectByUsersId(Integer uid);

    /**
     * 新增用户
     * @param users
     * @return
     */
    public Integer insertUsers(Users users);

    /**
     * 修改用户
     * @param users
     * @return
     */
    public Integer updateUsers(Users users);

    /**
     * 根据用户编号修改状态
     * @param usersid state
     * @return
     */
    public Integer updateUsersState(@Param("usersid") Integer usersid,
                                    @Param("state") Integer state);
}
