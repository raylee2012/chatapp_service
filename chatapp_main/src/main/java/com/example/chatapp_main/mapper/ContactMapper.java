package com.example.chatapp_main.mapper;

import com.example.chatapp_main.pojo.Contact;
import com.example.chatapp_main.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ContactMapper {

    void insertSelective(Contact contact);

    Contact selectContactByPrimaryKey(@Param("contact_id") String contact_id);

    Contact selectContactByContactores(@Param("applicant_id") String applicant_id,@Param("receiver_id") String receiver_id);

    void updateContactInfo(Contact contact);
}