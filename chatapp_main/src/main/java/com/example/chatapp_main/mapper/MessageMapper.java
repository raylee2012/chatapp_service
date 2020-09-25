package com.example.chatapp_main.mapper;

import com.example.chatapp_main.entity.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MessageMapper {

    void insertSelective(Message message);

    Message selectUserByPrimaryKey(@Param("message_id") String message_id);

    void updateMessageInfo(Message message);

    List<Message> getMessageList(@Param("message_group_id") String message_group_id);
}
