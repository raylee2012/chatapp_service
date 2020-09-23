package com.example.chatapp_main.service;

import com.example.chatapp_main.dao.GroupDao;
import com.example.chatapp_main.dao.GroupMemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService{
    @Autowired
    GroupDao groupDao;
    @Autowired
    GroupMemberDao groupMemberDao;

    @Override
    public void createGroup(String create_user_id, List<String> group_member_user_ids) {
        String group_id = groupDao.createGroup(create_user_id);
        group_member_user_ids.add(create_user_id);
        groupMemberDao.addGroupMembers(group_id,group_member_user_ids);
    }
}
