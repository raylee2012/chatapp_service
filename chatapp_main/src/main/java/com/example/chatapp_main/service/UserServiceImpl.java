package com.example.chatapp_main.service;

import com.example.chatapp_main.dao.UserDao;
import com.example.chatapp_main.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;

    @Override
    public boolean userNameIsRegister(String username) {
        User user = userDao.findUserByUsernam(username);
        if(user!=null){
            return true;
        }
        return false;
    }

    @Override
    public void register(String username, String password) {
        userDao.register(username, password);

    }

    @Override
    public boolean login(String username, String password) {
        User user = userDao.login(username, password);
        if(user!=null){
            return true;
        }
        return false;
    }

    @Override
    public void updateUserInfo(User user) {
        userDao.updateUserInfo(user);
    }

    @Override
    public User selectUserByPrimaryKey(int id) {

        return userDao.selectUserByPrimaryKey(id);
    }
}
