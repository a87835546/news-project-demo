package com.yicen.utils;


public enum ResponseStatusEnum {

    SUCCESS(200,true,"success"),
    FAILED(500,false,"操作失败"),


    GET_MESSAGE_CODE_SUCCESS(200,true,"获取验证码成功"),
    USER_FROZEN(510,true,"账号已经被冻结"),
    UN_LOGIN(501,false,"请先登录"),
    INVALID_MSG_CODE(502,false,"验证码有误"),
    GET_MESSAGE_CODE_TIMEOUT(502,false,"获取验证码太快，60秒后再次获取");

    private Integer status;
    private Boolean success;
    private String msg;


    private ResponseStatusEnum(Integer status, Boolean success, String msg){
        this.msg = msg;
        this.success = success;
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
