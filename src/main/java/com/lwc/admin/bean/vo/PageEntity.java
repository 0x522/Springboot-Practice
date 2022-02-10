package com.lwc.admin.bean.vo;

public class PageEntity {
    Integer code;
    Object data;
    Integer count;
    String msg;

    public PageEntity(Object data, Integer count) {
        this.code = 0;
        this.data = data;
        this.count = count;
        this.msg = "";
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
