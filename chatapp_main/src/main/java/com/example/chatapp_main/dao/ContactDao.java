package com.example.chatapp_main.dao;

import com.example.chatapp_main.mapper.ContactMapper;
import com.example.chatapp_main.mapper.UserMapper;
import com.example.chatapp_main.pojo.Contact;
import com.example.chatapp_main.pojo.User;
import com.example.chatapp_main.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ContactDao {

    @Autowired
    ContactMapper contactMapper;

    public Contact selectContactByContactores(String applicant_id,String receiver_id){
        return contactMapper.selectContactByContactores(applicant_id,receiver_id);
    }

    public void addContact(String applicant_id,String receiver_id,String application_content){
        Contact contact = new Contact();
        contact.setContact_id(StringUtil.newGUID());
        contact.setApplicant_id(applicant_id);
        contact.setReceiver_id(receiver_id);
        contact.setApplication_content(application_content);
        contact.setStatus("0");
        contact.setCreate_time(new Date());
        contact.setUpdate_time(new Date());
        contactMapper.insertSelective(contact);
    }

    public Contact selectContactByPrimaryKey(String contact_id){
        return contactMapper.selectContactByPrimaryKey(contact_id);
    }

    public void updateContactInfo(Contact contact){
        contactMapper.updateContactInfo(contact);
    }

}
