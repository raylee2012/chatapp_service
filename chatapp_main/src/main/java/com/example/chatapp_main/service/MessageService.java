package com.example.chatapp_main.service;


import com.example.chatapp_main.entity.Message;

public interface MessageService {

    void sendMessage(Message message);

    Message selectUserByPrimaryKey(String message_id);

    void revocationMessage(String message_id);
}
