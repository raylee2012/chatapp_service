package com.example.chatapp_main.service;

import com.example.chatapp_main.entity.User;
import com.example.chatapp_main.entity.vo.FindUser;

public interface UserService {
    boolean userNameIsRegister(String username);

    void register(String user_name,String password);

    boolean login(String username,String password);

    void updateUserInfo(User user);

    User selectUserByPrimaryKey(String user_id);

    FindUser findUserByUsername(String username);
}
