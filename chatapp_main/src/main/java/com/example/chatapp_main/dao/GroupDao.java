package com.example.chatapp_main.dao;

import com.example.chatapp_main.entity.Group;
import com.example.chatapp_main.mapper.GroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class GroupDao {

    @Autowired
    GroupMapper groupMapper;

    public void createGroup(String create_user_id){
        Group group = new Group();
        group.setCreate_time(new Date());
        group.setUpdate_time(new Date());
        group.setCreate_user_id(create_user_id);
        groupMapper.insertSelective(group);
    }


}
