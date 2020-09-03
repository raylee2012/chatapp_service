package com.example.chatapp_main.entity.vo;

import com.example.chatapp_main.entity.Contact;
import com.example.chatapp_main.entity.User;


public class Applicant extends Contact {
    private User applicantUser;//申请人

    public User getApplicantUser() {
        return applicantUser;
    }

    public void setApplicantUser(User applicantUser) {
        this.applicantUser = applicantUser;
    }
}
