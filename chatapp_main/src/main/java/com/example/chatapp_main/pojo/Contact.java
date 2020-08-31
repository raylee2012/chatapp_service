package com.example.chatapp_main.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Contact {

    private String contact_id; //'联系人编号',
    private String applicant_id; // '申请人id',
    private String receiver_id; //  '接收人id',
    private String application_content; //  '申请内容',
    private String status; //  '0未通过,1已通过,2已拒绝',
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date create_time; //  '创建时间',
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date update_time; //  '更新时间',

    public String getContact_id() {
        return contact_id;
    }

    public void setContact_id(String contact_id) {
        this.contact_id = contact_id;
    }

    public String getApplicant_id() {
        return applicant_id;
    }

    public void setApplicant_id(String applicant_id) {
        this.applicant_id = applicant_id;
    }

    public String getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(String receiver_id) {
        this.receiver_id = receiver_id;
    }

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
