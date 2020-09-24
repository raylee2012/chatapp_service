package com.example.chatapp_main.mapper;

import com.example.chatapp_main.entity.Group;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GroupMapper {

    Group selectByGroupId(@Param("group_id") String group_id);

    void insertSelective(Group group);

    void updateGroupInfo(Group group);

    void deleteByGroupid(String group_id);
}