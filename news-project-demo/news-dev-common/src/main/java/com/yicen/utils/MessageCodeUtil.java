package com.yicen.utils;


import org.springframework.stereotype.Component;

@Component
public class MessageCodeUtil {

    /**
     * 获取短信验证码 长度6位
     * @return
     */
    public static String getMessageCode(){
        int code =  (int) ((Math.random()+1)*100000);
        return code + "";
    }
}
