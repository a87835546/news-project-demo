package com.yicen.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class AppUser {

    @Id
    private Long id;

    private String mobile;

    private String nickname;

    private String email;

    private byte sex;

    private Date birthday;

    private byte activeStatus;

    private String realname;

    private String province;

    private String city;

    private String district;

    private String avatar;


    private Date gmtCreate;

    private Date gmtModify;

}
