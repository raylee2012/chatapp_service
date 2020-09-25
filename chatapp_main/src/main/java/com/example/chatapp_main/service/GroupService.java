package com.example.chatapp_main.service;



import com.example.chatapp_main.entity.Group;

import java.util.List;

public interface GroupService {

    Group selectByGroupId(String group_id);

    Group createGroup(String create_user_id, List<String> group_member_user_ids);

    void updateGroupInfo(String group_id,String group_name, String group_notice);

    void exitGroup(String group_id,String group_member_user_id);

    void deleteGroup(String group_id);

    void addMembers(String group_id,List<String> member_user_ids);

    void changDisturb(String group_id,String member_user_id,String group_disturb);

    void saveToContact(String group_id,String member_user_id,String group_to_contact);

    void setGroupTop(String group_id,String member_user_id,String group_top);

    void setGroupNickName(String group_id,String member_user_id,String group_nick_name);
}
