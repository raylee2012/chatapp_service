package com.example.chatapp_main.mapper;

import com.example.chatapp_main.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    User findUserByUsername(@Param("user_name") String username);

    void insertSelective(User user);

    User checkUsernameAndPassword(@Param("user_name") String username,@Param("password") String password);

    User selectUserByPrimaryKey(@Param("user_id") String user_id);

    void updateUserInfo(User user);
}