package com.example.chatapp_main.bean;

public enum  Status {
    OK("success", "成功"),
    NOTFOUNTUSER("error", "无此用户数据"),
    USERISREGISTER("error","用户名已注册"),
    PARAMILLEGAL("error","参数不合法"),
    NOLOGINNAME("error", "请提供用户名"),
    NOWEBSITENAME("error", "请提供网站名称"),
    ERROR("error","未知错误");

    private String key;
    private String value;
    //自定义的构造函数，参数数量，名字随便自己取
    //构造器默认也只能是private, 从而保证构造函数只能在内部使用
    private Status(String key, String value)
    {
        this.key = key;
        this.value = value;
    }

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }
    //重新toString方法，默认的toString方法返回的就是枚举变量的名字，和name()方法返回值一样
    @Override
    public String toString()
    {
        return this.key+":"+this.value;
    }
}
