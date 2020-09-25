package com.example.chatapp_main.dao;

import com.example.chatapp_main.entity.Message;
import com.example.chatapp_main.entity.User;
import com.example.chatapp_main.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class MessageDao {

    @Autowired
    MessageMapper messageMapper;

    public void addMessage(Message message){
        message.setCreate_time(new Date());
        message.setUpdate_time(new Date());
        messageMapper.insertSelective(message);
    }

    public Message selectUserByPrimaryKey(String message_id){
        return messageMapper.selectUserByPrimaryKey(message_id);
    }

    public void updateMessageInfo(Message message){
        messageMapper.updateMessageInfo(message);
    }

    public List<Message> getMessageList(String message_group_id){
        return messageMapper.getMessageList(message_group_id);
    }
}
