package com.study.model.mapper.aftersale;

import com.study.model.pojo.aftersale.Attachment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AttachmentMapper {
    public List<Attachment> fjzlcx(String nr);
    public void fjzlxz(Attachment attachment);
}
