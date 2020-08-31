package com.example.chatapp_main.dao;

import com.example.chatapp_main.mapper.UserMapper;
import com.example.chatapp_main.pojo.User;
import com.example.chatapp_main.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UserDao {

    @Autowired
    UserMapper userMapper;

    public User findUserByUsername(String user_name){
        return userMapper.findUserByUsername(user_name);
    }

    public void register(String user_name,String password){
        User user = new User();
        user.setUser_id(StringUtil.newGUID());
        user.setUser_name(user_name);
        user.setPassword(password);
        user.setCreate_time(new Date());
        user.setUpdate_time(new Date());
        userMapper.insertSelective(user);
    }

    public User login(String user_name,String password){
        return userMapper.checkUsernameAndPassword(user_name,password);
    }

    public User selectUserByPrimaryKey(String user_id){
        return userMapper.selectUserByPrimaryKey(user_id);
    }

    public void updateUserInfo(User user){
         userMapper.updateUserInfo(user);
    }

}
