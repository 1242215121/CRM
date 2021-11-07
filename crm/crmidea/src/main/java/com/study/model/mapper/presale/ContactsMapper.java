package com.study.model.mapper.presale;

import com.study.model.pojo.presale.Contacts;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContactsMapper {
    public List<Contacts> seContacts();

}
