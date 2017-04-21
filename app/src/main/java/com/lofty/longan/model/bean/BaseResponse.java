package com.lofty.longan.model.bean;


import java.io.Serializable;

public class BaseResponse<T> implements Serializable {

    protected int code;
    protected T data;
    protected String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
