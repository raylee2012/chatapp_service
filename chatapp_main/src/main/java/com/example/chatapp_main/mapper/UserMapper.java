package com.example.chatapp_main.mapper;

import com.example.chatapp_main.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    User findUserByUsernam(@Param("username") String username);

    void insertSelective(User user);

    User checkUsernameAndPassword(@Param("username") String username,@Param("password") String password);
}