package com.yicen.user;

import com.yicen.pojo.bo.UserLoginAndRegisterDo;
import com.yicen.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
@Api(value = "通行证接口文档",tags = "通行证接口文档")
public interface PassportControllerApi {
    @ApiOperation(value = "通过手机号码获取短信验证码",notes = "获取短信验证码")
    @GetMapping("getMessageCode")
    JSONResult getMessageCode(@RequestParam String mobile, HttpServletRequest request);

    @ApiOperation(value = "登录和注册接口",notes = "如果有注册账号就去注册")
    @PostMapping("/loginAndRegister")
    JSONResult loginAndRegister(@RequestBody UserLoginAndRegisterDo userLoginAndRegisterDo);

    @ApiOperation(value = "退出登录",notes = "退出登录")
    @PostMapping("/logout")
    JSONResult logout(@RequestBody String userId);
}
