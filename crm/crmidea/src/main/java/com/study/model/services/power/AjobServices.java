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
}
