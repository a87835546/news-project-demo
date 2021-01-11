package com.yicen.exception;

import com.yicen.utils.JSONResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyCustomExceptionHandler {

    @ExceptionHandler(MyCustomException.class)
    @ResponseBody
    public JSONResult returnMyException(MyCustomException e){
        e.printStackTrace();
        return JSONResult.error(e.getResponseStatusEnum());
    }
}
