package com.yicen.user.aop;


import ch.qos.logback.core.util.DatePatternToRegexUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class MyRequestAspect {

    public static final Logger logger = LoggerFactory.getLogger(MyRequestAspect.class);

    @Around("execution(* com.yicen.*.controller.*.*(..))")
    public Object getRequestTime(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("========请求开始 [{}]:[{}] =====",joinPoint.getTarget().getClass(),joinPoint.getSignature().getName());
        long start = System.currentTimeMillis();

        Object result =  joinPoint.proceed();
        long end = System.currentTimeMillis();
        if (end -start > 3000){ // 如果请求大于3秒
            logger.debug("请求的时长：{}ms",end-start);
        }else {
            logger.info("请求的时长：{}ms",end-start);
        }
        return result;
    }
}
