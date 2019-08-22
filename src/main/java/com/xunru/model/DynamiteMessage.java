package com.xunru.model;

import lombok.Data;

import java.util.Date;

@Data
public class DynamiteMessage {
    private String id;

    private String dynamiteMessageId;

    private String publisherId;

    private String publisherName;

    private String title;

    private String dynamiteContent;

    private String dynamiteContentImgUrl;

    private String contentTag;

    private Integer dynamiteLikeCount;

    private Date createTime;

}