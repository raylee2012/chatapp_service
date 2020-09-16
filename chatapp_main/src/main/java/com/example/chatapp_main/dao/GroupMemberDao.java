package com.example.chatapp_main.dao;

import com.example.chatapp_main.entity.GroupMember;
import com.example.chatapp_main.mapper.GroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GroupMemberDao {

    @Autowired
    GroupMapper groupMapper;

    public void addGroupMembers(List<GroupMember> groupMembers){

    }

    
}
