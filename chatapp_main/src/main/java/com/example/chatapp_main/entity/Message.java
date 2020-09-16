package com.example.chatapp_main.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Message {
    private String message_id;//'消息编号',
    private String message_group_id;// '消息所属群编号',
    private String message_create_user_id;//'创建消息的用户编号',
    private String message_content;// '消息内容',
    private String message_attach_url;// '附件消息文件地址',
    private String message_attach_name;//'附件消息文件名',
    private String message_attach_size;//'附件消息文件大小',
    private String message_revocation;// '0非撤回消息,1撤回消息',
    private String message_type;//'0文本消息,1图片消息,2语音消息,3视频消息,4位置消息',
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date create_time;//'创建时间',
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date update_time;// '更新时间',

    public String getMessage_id() {
        return message_id;
    }

    public void setMessage_id(String message_id) {
        this.message_id = message_id;
    }

    public String getMessage_group_id() {
        return message_group_id;
    }

    public void setMessage_group_id(String message_group_id) {
        this.message_group_id = message_group_id;
    }

    public String getMessage_create_user_id() {
        return message_create_user_id;
    }

    public void setMessage_create_user_id(String message_create_user_id) {
        this.message_create_user_id = message_create_user_id;
    }

    public String getMessage_content() {
        return message_content;
    }

    public void setMessage_content(String message_content) {
        this.message_content = message_content;
    }

    public String getMessage_attach_url() {
        return message_attach_url;
    }

    public void setMessage_attach_url(String message_attach_url) {
        this.message_attach_url = message_attach_url;
    }

    public String getMessage_attach_name() {
        return message_attach_name;
    }

    public void setMessage_attach_name(String message_attach_name) {
        this.message_attach_name = message_attach_name;
    }

    public String getMessage_attach_size() {
        return message_attach_size;
    }

    public void setMessage_attach_size(String message_attach_size) {
        this.message_attach_size = message_attach_size;
    }

    public String getMessage_revocation() {
        return message_revocation;
    }

    public void setMessage_revocation(String message_revocation) {
        this.message_revocation = message_revocation;
    }

    public String getMessage_type() {
        return message_type;
    }

    public void setMessage_type(String message_type) {
        this.message_type = message_type;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}
