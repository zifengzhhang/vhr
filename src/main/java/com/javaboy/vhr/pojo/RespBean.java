package com.javaboy.vhr.pojo;

public class RespBean {

    private Integer status;
    private String msg;
    private Object object;

    public static RespBean build() {
        return new RespBean();
    }

    private RespBean() {
    }

    private RespBean(Integer status, String msg, Object object) {
        this.status = status;
        this.msg = msg;
        this.object = object;
    }

    public static RespBean success(String msg) {
        return new RespBean(200, msg, null);
    }

    public static RespBean success(String msg, Object object) {
        return new RespBean(200, msg, object);
    }

    public static RespBean fail(String msg) {
        return new RespBean(500, msg, null);
    }

    public static RespBean fail(String msg, Object object) {
        return new RespBean(500, msg, object);
    }

    public Integer getStatus() {
        return status;
    }

    public RespBean setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public RespBean setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getObject() {
        return object;
    }

    public RespBean setObject(Object object) {
        this.object = object;
        return this;
    }
}
