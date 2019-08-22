package com.xunru.model;

import lombok.Data;

import java.util.Date;

@Data
public class DynamiteComment {
    private String id;

    private String dynamiteCommentId;

    private String dynamiteMessageId;

    private String commentUserId;

    private String commentUserName;

    private String commentContent;

    private Integer dynamiteLikeCount;

    private Date createTime;
}