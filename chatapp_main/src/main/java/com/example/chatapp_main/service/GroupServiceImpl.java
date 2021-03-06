package com.example.chatapp_main.service;

import com.example.chatapp_main.dao.GroupDao;
import com.example.chatapp_main.dao.GroupMemberDao;
import com.example.chatapp_main.entity.Group;
import com.example.chatapp_main.entity.GroupMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService{
    @Autowired
    GroupDao groupDao;
    @Autowired
    GroupMemberDao groupMemberDao;

    @Override
    public Group selectByGroupId(String group_id) {
        return groupDao.selectByGroupId(group_id);
    }

    @Override
    public Group createGroup(String create_user_id, List<String> group_member_user_ids) {
        Group group = groupDao.createGroup(create_user_id);
        group_member_user_ids.add(create_user_id);
        groupMemberDao.addGroupMembers(group.getGroup_id(),group_member_user_ids);
        return group;
    }

    @Override
    public void updateGroupInfo(String group_id, String group_name, String group_notice) {
        groupDao.updateGroupInfo(group_id,group_name,group_notice);
    }

    @Override
    public void exitGroup(String group_id, String group_member_user_id) {
        groupMemberDao.exitGroup(group_id,group_member_user_id);
    }

    @Override
    public void deleteGroup(String group_id) {
        groupDao.deleteByGroupid(group_id);
        groupMemberDao.deleteByGroupid(group_id);
    }

    @Override
    public void addMembers(String group_id, List<String> member_user_ids) {
        groupMemberDao.addGroupMembers(group_id, member_user_ids);
    }

    @Override
    public void changDisturb(String group_id, String member_user_id, String group_disturb) {
        GroupMember groupMember = new GroupMember();
        groupMember.setGroup_id(group_id);
        groupMember.setGroup_member_user_id(member_user_id);
        groupMember.setUpdate_time(new Date());
        groupMember.setGroup_disturb(group_disturb);
        groupMemberDao.updateGroupMemberInfo(groupMember);
    }

    @Override
    public void saveToContact(String group_id, String member_user_id, String group_to_contact) {
        GroupMember groupMember = new GroupMember();
        groupMember.setGroup_id(group_id);
        groupMember.setGroup_member_user_id(member_user_id);
        groupMember.setUpdate_time(new Date());
        groupMember.setGroup_to_contact(group_to_contact);
        groupMemberDao.updateGroupMemberInfo(groupMember);
    }

    @Override
    public void setGroupTop(String group_id, String member_user_id, String group_top) {
        GroupMember groupMember = new GroupMember();
        groupMember.setGroup_id(group_id);
        groupMember.setGroup_member_user_id(member_user_id);
        groupMember.setUpdate_time(new Date());
        groupMember.setGroup_top_update_time(new Date());
        groupMember.setGroup_top(group_top);
        groupMemberDao.updateGroupMemberInfo(groupMember);
    }

    @Override
    public void setGroupNickName(String group_id, String member_user_id, String group_nick_name) {
        GroupMember groupMember = new GroupMember();
        groupMember.setGroup_id(group_id);
        groupMember.setGroup_member_user_id(member_user_id);
        groupMember.setUpdate_time(new Date());
        groupMember.setGroup_nick_name(group_nick_name);
        groupMemberDao.updateGroupMemberInfo(groupMember);
    }
}
