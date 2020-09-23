package com.example.chatapp_main.service;



import java.util.List;

public interface GroupService {

    void createGroup(String create_user_id, List<String> group_member_user_ids);

    void updateGroupInfo(String group_id,String group_name, String group_notice);

}
