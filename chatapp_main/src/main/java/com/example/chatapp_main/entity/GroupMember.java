package com.example.chatapp_main.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class GroupMember {
    private String group_member_id;//'群成员编号',
    private String group_member_user_id;//'群成员用户编号',
    private String group_note;// '群备注',
    private String group_disturb;// '0未开启消息免打扰,1开启消息免打扰',
    private String group_to_contact;//'0不保存到通讯录,1保存到通讯录',
    private String group_top;//'0消息未置顶,1消息置顶',
    private String group_nick_name;// '个人设置的群昵称',
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date group_top_update_time;// '消息置顶状态更新时间',
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date create_time;// '创建时间',
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date update_time;//'更新时间',

    public String getGroup_member_id() {
        return group_member_id;
    }

    public void setGroup_member_id(String group_member_id) {
        this.group_member_id = group_member_id;
    }

    public String getGroup_member_user_id() {
        return group_member_user_id;
    }

    public void setGroup_member_user_id(String group_member_user_id) {
        this.group_member_user_id = group_member_user_id;
    }

    public String getGroup_note() {
        return group_note;
    }

    public void setGroup_note(String group_note) {
        this.group_note = group_note;
    }

    public String getGroup_disturb() {
        return group_disturb;
    }

    public void setGroup_disturb(String group_disturb) {
        this.group_disturb = group_disturb;
    }

    public String getGroup_to_contact() {
        return group_to_contact;
    }

    public void setGroup_to_contact(String group_to_contact) {
        this.group_to_contact = group_to_contact;
    }

    public String getGroup_top() {
        return group_top;
    }

    public void setGroup_top(String group_top) {
        this.group_top = group_top;
    }

    public String getGroup_nick_name() {
        return group_nick_name;
    }

    public void setGroup_nick_name(String group_nick_name) {
        this.group_nick_name = group_nick_name;
    }

    public Date getGroup_top_update_time() {
        return group_top_update_time;
    }

    public void setGroup_top_update_time(Date group_top_update_time) {
        this.group_top_update_time = group_top_update_time;
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
