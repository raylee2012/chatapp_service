package com.example.chatapp_main.pojo;

import java.util.List;

public class Applicant extends Contact{
    private List<User> user;

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
}
