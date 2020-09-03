package com.example.chatapp_main.mapper;

import com.example.chatapp_main.entity.vo.Applicant;
import com.example.chatapp_main.entity.Contact;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ContactMapper {

    void insertSelective(Contact contact);

    Contact selectContactByPrimaryKey(@Param("contact_id") String contact_id);

    Contact selectContactByContactores(@Param("applicant_id") String applicant_id,@Param("receiver_id") String receiver_id);

    void updateContactInfo(Contact contact);

    List<Applicant> getApplicantList(@Param("receiver_id") String receiver_id);
}