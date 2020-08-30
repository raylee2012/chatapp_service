package com.example.chatapp_main.service;

import com.example.chatapp_main.pojo.User;

public interface UserService {
    boolean userNameIsRegister(String username);

    void register(String username,String password);

    boolean login(String username,String password);

    void updateUserInfo(User user);

    User selectUserByPrimaryKey(int id);

    User findUserByUsernam(String username);
}
