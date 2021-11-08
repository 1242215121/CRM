package com.study.model.services.presale;

import com.study.model.mapper.presale.ClueMapper;
import com.study.model.pojo.presale.Clue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClueService {
    @Autowired
    ClueMapper clueMapper;
    public List<Clue> seClue(){
        return clueMapper.seClue();
    }
    public Object selectClueByPage(Integer pageNo,Integer size,String clueName){
        return clueMapper.selectClue(clueName);
    }
    public Integer inClue(Clue clue){
        return clueMapper.inClue(clue);
    }
}
