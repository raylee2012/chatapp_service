package com.example.chatapp_main.service;

public interface UserService {
    boolean userNameIsRegister(String username);

    void register(String username,String password);
}
