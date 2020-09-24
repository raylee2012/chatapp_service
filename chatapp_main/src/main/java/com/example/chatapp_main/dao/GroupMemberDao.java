package com.example.chatapp_main.dao;

import com.example.chatapp_main.entity.GroupMember;
import com.example.chatapp_main.mapper.GroupMapper;
import com.example.chatapp_main.mapper.GroupMemberMapper;
import com.example.chatapp_main.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class GroupMemberDao {

    @Autowired
    GroupMemberMapper groupMemberMapper;

    public void addGroupMembers(String group_id,List<String> group_member_user_ids){
        for(String group_member_user_id:group_member_user_ids){
            GroupMember groupMember = new GroupMember();
            groupMember.setGroup_member_id(StringUtil.newGUID());
            groupMember.setGroup_id(group_id);
            groupMember.setGroup_member_user_id(group_member_user_id);
            groupMember.setCreate_time(new Date());
            groupMember.setUpdate_time(new Date());
            groupMemberMapper.insertSelective(groupMember);
        }
    }

    public void exitGroup(String group_id, String group_member_user_id){
        groupMemberMapper.exitGroup(group_id,group_member_user_id);
    }

    public void deleteByGroupid(String group_id){
        groupMemberMapper.deleteByGroupid(group_id);
    }
}
