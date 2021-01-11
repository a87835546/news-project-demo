package com.yicen.user.service;
import com.yicen.pojo.AppUser;
import com.yicen.pojo.bo.UserLoginAndRegisterDo;
import com.yicen.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;


    @Transactional
    public AppUser loginAndRegister(UserLoginAndRegisterDo userLoginAndRegisterDo){
        System.out.println(userMapper + "userMapper");
        AppUser user = userMapper.findUserByPhone(userLoginAndRegisterDo.getMobile());
        if (null != user){
            return  user;
        }else {
            Boolean b  = userMapper.registerByPhone(userLoginAndRegisterDo.getMobile());
            System.out.println("插入用户成功还是失败"+b);
            if (b){
                user = userMapper.findUserByPhone(userLoginAndRegisterDo.getMobile());
            }
            return user;
        }
    }

    public AppUser getUserInfoById(String userId){
        return userMapper.getUserInfoById(userId);
    }
}
