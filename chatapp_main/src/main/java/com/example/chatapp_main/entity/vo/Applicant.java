package com.example.chatapp_main.entity.vo;

import com.example.chatapp_main.entity.Contact;
import com.example.chatapp_main.entity.User;


public class Applicant extends Contact {
    private User applicant;//申请人

    public User getApplicant() {
        return applicant;
    }

    public void setApplicant(User applicant) {
        this.applicant = applicant;
    }
}
