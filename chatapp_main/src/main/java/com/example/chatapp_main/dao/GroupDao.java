package com.example.chatapp_main.dao;

import com.example.chatapp_main.entity.Group;
import com.example.chatapp_main.mapper.GroupMapper;
import com.example.chatapp_main.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class GroupDao {

    @Autowired
    GroupMapper groupMapper;

    public Group selectByGroupId(String group_id){
       return groupMapper.selectByGroupId(group_id);
    }

    public String createGroup(String create_user_id){
        Group group = new Group();
        group.setGroup_id(StringUtil.newGUID());
        group.setCreate_time(new Date());
        group.setUpdate_time(new Date());
        group.setCreate_user_id(create_user_id);
        groupMapper.insertSelective(group);

        return group.getGroup_id();
    }

    public void updateGroupInfo(String group_id,String group_name, String group_notice){
        Group group = new Group();
        group.setGroup_id(group_id);
        group.setGroup_name(group_name);
        group.setGroup_notice(group_notice);
        group.setUpdate_time(new Date());
        groupMapper.updateGroupInfo(group);
    }

    public void exitGroup(String group_id, String group_member_user_id){

    }

}
