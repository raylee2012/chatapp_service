package com.example.chatapp_main.service;



import com.example.chatapp_main.entity.Group;

import java.util.List;

public interface GroupService {

    Group selectByGroupId(String group_id);

    void createGroup(String create_user_id, List<String> group_member_user_ids);

    void updateGroupInfo(String group_id,String group_name, String group_notice);

    void exitGroup(String group_id,String group_member_user_id);
}
