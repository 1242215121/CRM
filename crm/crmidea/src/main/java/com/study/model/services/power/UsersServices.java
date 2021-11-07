package com.study.model.services.power;

import com.study.model.mapper.power.UsersMapper;
import com.study.model.pojo.power.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UsersServices {
    @Autowired
    UsersMapper mapper;

    /**
     * 根据用户名查询用户
     * @param name  用户名
     * @return
     */
    public Users selectByUsersName(String name){
        return mapper.selectByUsersName(name);
    }

    /**
     * 查询所有用户
     * @return
     */
    public List<Users> selectAll(){
        return mapper.selectAll();
    }

    /**
     * 根据职位编号查询用户
     * @param jobid  职位编号
     * @return
     */
    public List<Users> selectByAjobId(Integer jobid){
        return mapper.selectByAjobId(jobid);
    }

    /**
     * 根据部门编号查询用户
     * @param deptid
     * @return
     */
    public List<Users> selectByDeptId(Integer deptid){
        return mapper.selectByDeptId(deptid);
    }


    /**
     * 根据用户编号查询
     * @param uid
     * @return
     */
    public Users selectByUsersId(Integer uid){
        return mapper.selectByUsersId(uid);
    }

    /**
     * 新增用户
     * @param users
     * @return
     */
    public Integer insertUsers(Users users){
        try{
            mapper.insertUsers(users);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 修改用户
     * @param users
     * @return
     */
    public Integer updateUsers(Users users){
        try{
            mapper.updateUsers(users);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }
}
