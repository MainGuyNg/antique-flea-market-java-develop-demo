package com.xunru.model;

import lombok.Data;

import java.util.Date;

@Data
public class Friend {
    private String id;

    private String userId;

    private String friendId;

    private String friendRemark;

    private String friendGroupId;

    private String isSpecialAttention;

    private Date createTime;

    private Date updateTime;

}