package com.example.chatapp_main.mapper;

import com.example.chatapp_main.entity.Group;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GroupMemberMapper {

    void insertSelective(Group group);
}