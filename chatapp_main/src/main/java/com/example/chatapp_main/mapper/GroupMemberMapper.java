package com.example.chatapp_main.mapper;

import com.example.chatapp_main.entity.GroupMember;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GroupMemberMapper {

    void insertSelective(GroupMember groupMember);
}