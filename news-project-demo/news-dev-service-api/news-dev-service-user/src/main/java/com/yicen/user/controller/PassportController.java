package com.yicen.user.controller;

import com.mysql.jdbc.StringUtils;
import com.yicen.pojo.AppUser;
import com.yicen.pojo.bo.UserLoginAndRegisterDo;
import com.yicen.pojo.vo.UserAccountInfoVo;
import com.yicen.user.PassportControllerApi;
import com.yicen.utils.IPUtil;
import com.yicen.utils.JSONResult;
import com.yicen.utils.MessageCodeUtil;
import com.yicen.utils.ResponseStatusEnum;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class PassportController extends BaseController implements PassportControllerApi {

    @Override
    public JSONResult getMessageCode(String mobile, HttpServletRequest request) {
        String ip = IPUtil.getRequestIp(request);
        String key = MESSAGE_CODE +":"+ ip;
        logger.info("ip:" + ip);
        String object = (String)redisUtil.get(key);
        logger.info("redis 中的验证码："+object);
        if (null != object){
            return JSONResult.error(ResponseStatusEnum.GET_MESSAGE_CODE_TIMEOUT);
        }else {
            String code =  MessageCodeUtil.getMessageCode();
            redisUtil.set(key,code,60);
            redisUtil.set(MESSAGE_CODE + ":" + mobile,code,30*60);
            return JSONResult.success();
        }
    }

    @Override
    public JSONResult loginAndRegister(UserLoginAndRegisterDo userLoginAndRegisterDo) {
        if (StringUtils.isNullOrEmpty(userLoginAndRegisterDo.getSmsCode())){
            return JSONResult.error(ResponseStatusEnum.INVALID_MSG_CODE);
        }
        System.out.println("获取的登录信息：" + userLoginAndRegisterDo);
        String key = MESSAGE_CODE + ":" + userLoginAndRegisterDo.getMobile();
        String code = (String)redisUtil.get(key);
        System.out.println("redis中获取验证码：" + code);
        if (userLoginAndRegisterDo.getSmsCode().equals(code)){
            redisUtil.del(key);
            AppUser user = userService.loginAndRegister(userLoginAndRegisterDo);
            if (user.getActiveStatus() == 2){ //账号冻结
                return JSONResult.error(ResponseStatusEnum.USER_FROZEN);
            }
            UserAccountInfoVo accountInfoVo = new UserAccountInfoVo();
            BeanUtils.copyProperties(user,accountInfoVo);
            return JSONResult.ok(accountInfoVo);
        }else {
            return JSONResult.error("验证码无效");
        }
    }

    @Override
    public JSONResult logout(String userId) {
        return JSONResult.error(ResponseStatusEnum.SUCCESS);
    }
}
