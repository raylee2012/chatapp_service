package com.example.chatapp_main.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


public class Applicant{
    private String application_content; //  '申请内容',
    private String status; //  '0未通过,1已通过,2已拒绝',
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date update_time; //  '更新时间',

    private String user_id;// '用户编号',
    private String user_name;// '用户名',
    private String nick_name;// '昵称',
    private String imgurl;// '用户头像地址',


    public String getApplication_content() {
        return application_content;
    }

    public void setApplication_content(String application_content) {
        this.application_content = application_content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}
