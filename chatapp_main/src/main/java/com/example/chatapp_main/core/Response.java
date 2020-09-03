package com.example.chatapp_main.core;


public class Response {
    private String flag;
    private String msg;
    private Object data;

    public void setStatus(Status status){
        this.flag=status.getKey();
        this.msg=status.getValue();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
