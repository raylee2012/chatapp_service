package com.example.chatapp_main.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Group {
    private String group_id;// '群编号',
    private String group_name; //'群名称',
    private String group_notice; //'群公告',
    private String create_user_id;// '创建人id',
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date create_time; // '创建时间',
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date update_time;// '更新时间',

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getGroup_notice() {
        return group_notice;
    }

    public void setGroup_notice(String group_notice) {
        this.group_notice = group_notice;
    }

    public String getCreate_user_id() {
        return create_user_id;
    }

    public void setCreate_user_id(String create_user_id) {
        this.create_user_id = create_user_id;
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
