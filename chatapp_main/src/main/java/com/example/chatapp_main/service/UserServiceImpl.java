package com.example.chatapp_main.service;

import com.example.chatapp_main.dao.UserDao;
import com.example.chatapp_main.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;



    @Override
    public boolean userNameIsRegister(String user_name) {
        User user = userDao.findUserByUsername(user_name);
        if(user!=null){
            return true;
        }
        return false;
    }

    @Override
    public void register(String user_name, String password) {
        userDao.register(user_name, password);

    }

    @Override
    public boolean login(String user_name, String password) {
        User user = userDao.login(user_name, password);
        if(user!=null){
            return true;
        }
        return false;
    }

    @Override
    public void updateUserInfo(User user) {
        user.setUpdate_time(new Date());
        userDao.updateUserInfo(user);
    }

    @Override
    public User selectUserByPrimaryKey(String user_id) {

        return userDao.selectUserByPrimaryKey(user_id);
    }

    @Override
    public User findUserByUsername(String user_name) {
        return userDao.findUserByUsername(user_name);
    }
}
