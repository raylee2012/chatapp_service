package com.example.chatapp_main.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class User {
    private String user_id;// '用户编号',
    private String user_name;// '用户名',
    private String nick_name;// '昵称',
    private String imgurl;// '用户头像地址',
    private String password;// '用户密码',
    private String tel;// '电话号码',
    private String address;//'地址',
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date create_time;//创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date update_time;//更新时间

    public User() {
    }

    public User(String user_id,String nick_name, String password, String tel, String address) {
        this.user_id = user_id;
        this.nick_name = nick_name;
        this.password = password;
        this.tel = tel;
        this.address = address;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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