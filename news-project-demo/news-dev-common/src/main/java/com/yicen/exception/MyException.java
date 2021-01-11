package com.yicen.exception;

import com.yicen.utils.ResponseStatusEnum;

/**
 * 统一处理异常
 */
public class MyException {
    public static void display(ResponseStatusEnum responseStatusEnum){
        throw  new MyCustomException(responseStatusEnum);
    }
}
