package com.example.chatapp_main.service;

import com.example.chatapp_main.entity.vo.Applicant;
import com.example.chatapp_main.entity.Contact;
import com.example.chatapp_main.entity.vo.Friend;

import java.util.List;

public interface ContactService {

    void addOrUpdateContact(String applicant_id,String receiver_id,String application_content);

    void updateContactStatus(String contact_id,String status);

    Contact selectContactByContactores(String applicant_id,String receiver_id);

    Contact selectContactByPrimaryKey(String contact_id);

    List<Applicant> getApplicantList(String receiver_id);

    List<Friend> getFriendList(String receiver_id,String status);
}
