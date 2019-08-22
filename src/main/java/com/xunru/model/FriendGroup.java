package com.xunru.model;

import lombok.Data;

import java.util.Date;

@Data
public class FriendGroup {
    private String id;

    private String userId;

    private String groupId;

    private String groupName;

    private Date createTime;

    private Date updateTime;

}