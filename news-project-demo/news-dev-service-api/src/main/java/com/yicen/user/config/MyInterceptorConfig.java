package com.yicen.user.config;

import com.yicen.exception.MyException;
import com.yicen.utils.IPUtil;
import com.yicen.utils.RedisUtil;
import com.yicen.utils.ResponseStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Configuration
public class MyInterceptorConfig implements HandlerInterceptor {

    @Autowired
    private IPUtil ipUtil;

    @Autowired
    private RedisUtil redisUtil;

    public static final String MESSAGE_CODE = "message:code";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String userIp = ipUtil.getRequestIp(request);
        boolean keyIsExist = redisUtil.keyISExist(MESSAGE_CODE+":"+userIp);
        if (keyIsExist){
            MyException.display(ResponseStatusEnum.GET_MESSAGE_CODE_TIMEOUT);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
