package com.example.chatapp_main.dao;

import com.example.chatapp_main.mapper.UserMapper;
import com.example.chatapp_main.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

    @Autowired
    UserMapper userMapper;

    public User findUserByUsernam(String username){
        return userMapper.findUserByUsernam(username);
    }

    public void register(String username,String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userMapper.insertSelective(user);
    }

    public User login(String username,String password){
        return userMapper.checkUsernameAndPassword(username,password);
    }

}
