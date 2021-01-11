package com.yicen.user.controller;
import com.mysql.jdbc.StringUtils;
import com.yicen.pojo.AppUser;
import com.yicen.pojo.vo.UserAccountInfoVo;
import com.yicen.user.UserControllerApi;
import com.yicen.utils.JSONResult;
import com.yicen.utils.ResponseStatusEnum;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController extends BaseController implements UserControllerApi {



    @Override
    public JSONResult test() {
        System.out.println("test......");
        JSONResult result = new JSONResult();
        return result.ok();
    }

    @Override
    public JSONResult test1() {
        return JSONResult.error();
    }


    @Override
    public JSONResult getUserInfo(String userId) {
        if (StringUtils.isNullOrEmpty(userId)){
            return JSONResult.error(ResponseStatusEnum.UN_LOGIN);
        }
        AppUser user = userService.getUserInfoById(userId);
        UserAccountInfoVo accountInfoVo = new UserAccountInfoVo();
        BeanUtils.copyProperties(user,accountInfoVo);
        return JSONResult.success(accountInfoVo);
    }


}
