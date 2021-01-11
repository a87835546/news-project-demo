package com.yicen.pojo.vo;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;
@Data
public class UserAccountInfoVo {

    @Id
    private Long id;

    private String mobile;

    private String nickname;

    private String email;

    private byte sex;

    private Date birthday;

    private String realname;

    private String province;

    private String city;

    private String district;

    private String avatar;

}
