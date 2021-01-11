package com.yicen.exception;

import com.yicen.utils.ResponseStatusEnum;

public class MyCustomException extends RuntimeException {

    private ResponseStatusEnum responseStatusEnum;

    public MyCustomException(ResponseStatusEnum responseStatusEnum){
        super("异常信息为：" + responseStatusEnum.getMsg() + "异常的状态码："+ responseStatusEnum.getStatus());
        this.responseStatusEnum = responseStatusEnum;
    }

    public ResponseStatusEnum getResponseStatusEnum() {
        return responseStatusEnum;
    }

    public void setResponseStatusEnum(ResponseStatusEnum responseStatusEnum) {
        this.responseStatusEnum = responseStatusEnum;
    }
}
