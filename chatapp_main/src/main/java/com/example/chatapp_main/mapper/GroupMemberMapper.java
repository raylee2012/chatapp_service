package com.example.chatapp_main.mapper;

import com.example.chatapp_main.entity.GroupMember;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GroupMemberMapper {

    void insertSelective(GroupMember groupMember);

    void exitGroup(@Param("group_id") String group_id, @Param("group_member_user_id") String group_member_user_id);

    void deleteByGroupid(@Param("group_id") String group_id);
}