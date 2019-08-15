package com.xunru.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
public class User {
    private String openid;

    private String unionid;

    private String realName;

    private String nickname;

    private Date birthday;

    private Integer sex;

    private String telephone;

    private String companyName;

    private String jobPosition;

    private String city;

    private String province;

    private String country;

    private String headimgurl;

    private String remark;

    private String subscribe;

    private Date subscribeTime;

    private Date registerTime;

    private Date loginTime;

    private Date modifyTime;
}