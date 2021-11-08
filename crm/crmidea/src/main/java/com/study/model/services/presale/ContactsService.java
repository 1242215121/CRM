package com.study.model.services.presale;

import com.study.model.mapper.presale.ContactsMapper;
import com.study.model.pojo.presale.Contacts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@Transactional
public class ContactsService {
    @Autowired
    ContactsMapper contactsMapper;

    public Object selectContactsByPage(Integer PageNo,Integer size,String contactsName){
        return contactsMapper.selectContacts(contactsName);
    }

    public List<Contacts> seContacts(){
        return contactsMapper.seContacts();
    }
}
