package com.study.model.mapper.presale;

import com.study.model.pojo.presale.Clue;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClueMapper {
    public List<Clue> seClue();
}
