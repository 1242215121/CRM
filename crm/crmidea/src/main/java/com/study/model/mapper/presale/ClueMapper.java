package com.study.model.mapper.presale;

import com.study.model.pojo.presale.Clue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClueMapper {
    //查询所有
    public List<Clue> seClue();

    //分页联表查询
    public List<Clue> selectClue(@Param("clueName")String clueName);
}
