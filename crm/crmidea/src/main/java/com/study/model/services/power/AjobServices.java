package com.study.model.services.power;

import com.study.model.mapper.power.AjobMapper;
import com.study.model.pojo.power.Ajob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AjobServices {
    @Autowired
    AjobMapper mapper;

    /**
     * 查询所有职位
     * @return
     */
    public List<Ajob> selectAll(){
        return mapper.selectAll();
    }

    /**
     * 根据职位编号查询职位
     * @return
     */
    public Ajob selectByAjobId(Integer jobid){
        return mapper.selectByAjobId(jobid);
    }

    /**
     * 根据职位编号查询职位  不查关系字段
     * @param jobid
     * @return
     */
    public Ajob selectByAjobIdNoUsers(Integer jobid){
        return mapper.selectByAjobIdNoUsers(jobid);
    }

    /**
     * 根据职位名称查询 用于验证
     * @param ajobname
     * @return
     */
    public Ajob selectByAjobName(String ajobname){
        return mapper.selectByAjobName(ajobname);
    }

    /**
     * 新增职位
     * @param ajob
     * @return
     */
    public Integer insertAjob(Ajob ajob){
        try {
            mapper.insertAjob(ajob);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 根据职位编号 修改职位
     * @param ajob
     * @return
     */
    public Integer updateAjob(Ajob ajob){
        try {
            mapper.updateAjob(ajob);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 根据编号 删除职位信息
     * @param ajobid
     * @return
     */
    public Integer deleteByAjobId(Integer ajobid){
        try {
            mapper.deleteByAjobId(ajobid);
            return 1;
        }catch (Exception e){
            return -1;
        }
    }
}
