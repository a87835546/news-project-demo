package com.yicen.user;
import com.yicen.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(value = "user controller api 接口文档",tags = "user controller api 接口文档")
@RequestMapping("user")
public interface UserControllerApi {

    @GetMapping("/test")
    @ApiOperation(value = "测试",notes = "测试接口")
    JSONResult test();

    @ApiOperation(value = "测试1",notes = "测试1接口")
    @GetMapping("/test1")
    JSONResult test1();

    @ApiOperation(value = "根据用户id获取用户信息",notes = "根据用户id获取用户信息")
    @PostMapping("/getUserInfo")
    JSONResult getUserInfo(@RequestBody String userId);

}
