package com.example.chatapp_main.service;

import com.example.chatapp_main.pojo.User;

public interface UserService {
    boolean userNameIsRegister(String username);

    void register(String user_name,String password);

    boolean login(String username,String password);

    void updateUserInfo(User user);

    User selectUserByPrimaryKey(String user_id);

    User findUserByUsername(String username);
}
