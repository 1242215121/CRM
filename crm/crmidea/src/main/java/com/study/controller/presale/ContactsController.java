package com.study.controller.presale;

import com.study.model.pojo.presale.Contacts;
import com.study.model.services.presale.ContactsService;
import com.study.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("contacts")
public class ContactsController {
MyResult myResult = new MyResult();
    @Autowired
    ContactsService contactsService;
    @RequestMapping("selectContacts")
    public MyResult selectContacts(@RequestBody Contacts contacts){
        return MyResult.SUCCESS_Object(contactsService.selectContactsByPage(contacts.getPageNo(),
                contacts.getSize(),contacts.getContactsName()));
    }


    @GetMapping
    public MyResult seContacts() {
        return MyResult.SUCCESS_DATA(contactsService.seContacts());
    }
    @PostMapping("inContacts")
    public MyResult inContacts(@RequestBody Contacts contactse){
        System.out.println(contactse);
        Integer a = contactsService.inContacts(contactse);
        if(a>0){
            myResult.setCode(1);
            System.out.println("新增成功");
            return MyResult.SUCCESS;
        }
        return MyResult.FAILURE("新增失败");

    }
}
