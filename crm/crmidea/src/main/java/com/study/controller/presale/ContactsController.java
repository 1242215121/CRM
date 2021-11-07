package com.study.controller.presale;

import com.study.model.pojo.presale.Contacts;
import com.study.model.services.presale.ContactsService;
import com.study.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("contacts")
public class ContactsController {

    @Autowired
    ContactsService contactsService;
    @GetMapping
    public MyResult seContacts(){
        return MyResult.SUCCESS_DATA(contactsService.seContacts());
    }
}
