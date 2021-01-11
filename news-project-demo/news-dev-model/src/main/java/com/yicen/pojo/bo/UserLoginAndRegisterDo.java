package com.yicen.pojo.bo;

import lombok.Data;
import javax.annotation.Resource;

@Resource
@Data
public class UserLoginAndRegisterDo {
    private String username;
    private String mobile;
    private String password;
    private String smsCode;
}
