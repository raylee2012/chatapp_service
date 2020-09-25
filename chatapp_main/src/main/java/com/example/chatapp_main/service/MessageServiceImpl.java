package com.example.chatapp_main.service;

import com.example.chatapp_main.dao.MessageDao;
import com.example.chatapp_main.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    MessageDao messageDao;

    @Override
    public void sendMessage(Message message) {
        messageDao.addMessage(message);
    }

    @Override
    public Message selectUserByPrimaryKey(String message_id) {
        return messageDao.selectUserByPrimaryKey(message_id);
    }

    @Override
    public void revocationMessage(String message_id) {
        Message message = new Message();
        message.setMessage_id(message_id);
        message.setMessage_revocation("1");
        message.setUpdate_time(new Date());
        messageDao.updateMessageInfo(message);
    }
}
