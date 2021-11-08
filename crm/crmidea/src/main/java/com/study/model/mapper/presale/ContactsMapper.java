package com.study.model.mapper.presale;

import com.study.model.pojo.presale.Contacts;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ContactsMapper {
    public List<Contacts> selectContacts(@Param("contactsName")String contactsName);

<<<<<<< .merge_file_a15316
<<<<<<< .merge_file_a11772
<<<<<<< .merge_file_a16984

=======
>>>>>>> .merge_file_a19548
    public List<Contacts> seContacts();

    public Integer inContacts(Contacts contactse);

=======
    public List<Contacts> seContacts();
    
    public Integer inContacts(Contacts contactse);
>>>>>>> .merge_file_a23040
=======

    public List<Contacts> seContacts();

    public Integer inContacts(Contacts contactse);

>>>>>>> .merge_file_a18908

}
