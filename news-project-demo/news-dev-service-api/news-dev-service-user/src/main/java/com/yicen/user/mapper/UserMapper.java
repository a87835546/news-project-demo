package com.yicen.user.mapper;

import com.yicen.pojo.AppUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    AppUser findUserByPhone(String mobile);

    Boolean registerByPhone(String mobile);

    AppUser getUserInfoById(String userId);
}
