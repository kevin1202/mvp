package com.lofty.longan.model.bean;

/**
 * 用户登录
 */
public class Login extends BaseResponse<Login> {



    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}