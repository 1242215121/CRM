package com.study.model.mapper.presale;

import com.study.model.pojo.presale.Contacts;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ContactsMapper {
    public List<Contacts> selectContacts(@Param("contactsName")String contactsName);

    public List<Contacts> seContacts();

    public Integer inContacts(Contacts contactse);


}
