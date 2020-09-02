package com.example.chatapp_main.service;

import com.example.chatapp_main.dao.ContactDao;
import com.example.chatapp_main.pojo.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ContactServiceImpl implements ContactService{
    @Autowired
    ContactDao contactDao;

    @Override
    public void addOrUpdateContact(String applicant_id, String receiver_id, String application_content) {
        Contact contact = contactDao.selectContactByContactores(applicant_id, receiver_id);
        if(contact==null){
            contactDao.addContact(applicant_id,receiver_id,application_content);
        }else{
            contact.setApplication_content(application_content);
            contact.setStatus("0");
            contactDao.updateContactInfo(contact);
        }
    }

    @Override
    public void updateContactStatus(String contact_id, String status) {
        Contact contact = new Contact();
        contact.setContact_id(contact_id);
        contact.setStatus(status);
        contact.setUpdate_time(new Date());
        contactDao.updateContactInfo(contact);
    }

    @Override
    public Contact selectContactByContactores(String applicant_id, String receiver_id) {
        return contactDao.selectContactByContactores(applicant_id,receiver_id);
    }

    @Override
    public Contact selectContactByPrimaryKey(String contact_id) {
        return contactDao.selectContactByPrimaryKey(contact_id);
    }

    @Override
    public List<Contact> getApplicantList(String receiver_id) {
        return contactDao.getApplicantList(receiver_id);
    }
}
