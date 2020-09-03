package com.example.chatapp_main.entity.vo;

import com.example.chatapp_main.entity.Contact;
import com.example.chatapp_main.entity.User;

import java.util.List;

public class Applicant extends Contact {
    private List<User> user;

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
}
