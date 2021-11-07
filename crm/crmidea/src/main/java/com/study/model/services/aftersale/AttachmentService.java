package com.study.model.services.aftersale;

import com.study.model.mapper.aftersale.AttachmentMapper;
import com.study.model.pojo.aftersale.Attachment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AttachmentService {
    @Autowired
    AttachmentMapper attachmentMapper;

    public Map<String,Object> fjzlcx(String nr){
        Map<String,Object> map=new HashMap<>();
        map.put("fjzl",attachmentMapper.fjzlcx(nr));
        return map;

    }

    public String fjzlxz(Attachment attachment){
        try{
            attachmentMapper.fjzlxz(attachment);
            return "ok";
        }catch (Exception e){
            return "no";
        }
    }
}
