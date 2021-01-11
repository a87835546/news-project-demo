package com.yicen.user.controller;

import com.yicen.user.service.UserService;
import com.yicen.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController  {

    public static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    public static final String MESSAGE_CODE = "message:code";

    @Autowired
    UserService userService;

    @Autowired
    RedisUtil redisUtil;


}
