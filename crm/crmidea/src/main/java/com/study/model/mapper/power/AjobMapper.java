package com.study.model.mapper.power;

import com.study.model.pojo.power.Ajob;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AjobMapper {

    /**
     * 查询所有职位
     * @return
     */
    public List<Ajob> selectAll();

    /**
     * 根据职位编号查询职位
     * @return
     */
    public Ajob selectByAjobId(Integer jobid);

    /**
     * 根据部门查询职位
     * @param deptid
     * @return
     */
    public List<Ajob> selectByDeptId(Integer deptid);

    /**
     * 根据职位编号查询职位  不查关系字段
     * @param jobid
     * @return
     */
    public Ajob selectByAjobIdNoUsers(Integer jobid);

    /**
     * 根据职位名称查询
     * @param ajobname
     * @return
     */
    public Ajob selectByAjobName(@Param("ajobname") String ajobname,@Param("deptid") Integer deptid);

    /**
     * 新增职位
     * @param ajob
     * @return
     */
    public Integer insertAjob(Ajob ajob);

    /**
     * 根据职位编号 修改职位
     * @param ajob
     * @return
     */
    public Integer updateAjob(Ajob ajob);

    /**
     * 根据编号 删除职位信息
     * @param ajobid
     * @return
     */
    public Integer deleteByAjobId(Integer ajobid);

    /**
     * 根据部门编号 删除职位信息
     * @param did
     * @return
     */
    public Integer deleteByDeptId(Integer did);
}
