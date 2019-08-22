package com.xunru.model;

import java.util.Date;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDynamiteMessageId() {
        return dynamiteMessageId;
    }

    public void setDynamiteMessageId(String dynamiteMessageId) {
        this.dynamiteMessageId = dynamiteMessageId == null ? null : dynamiteMessageId.trim();
    }

    public String getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId == null ? null : publisherId.trim();
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName == null ? null : publisherName.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDynamiteContent() {
        return dynamiteContent;
    }

    public void setDynamiteContent(String dynamiteContent) {
        this.dynamiteContent = dynamiteContent == null ? null : dynamiteContent.trim();
    }

    public String getDynamiteContentImgUrl() {
        return dynamiteContentImgUrl;
    }

    public void setDynamiteContentImgUrl(String dynamiteContentImgUrl) {
        this.dynamiteContentImgUrl = dynamiteContentImgUrl == null ? null : dynamiteContentImgUrl.trim();
    }

    public String getContentTag() {
        return contentTag;
    }

    public void setContentTag(String contentTag) {
        this.contentTag = contentTag == null ? null : contentTag.trim();
    }

    public Integer getDynamiteLikeCount() {
        return dynamiteLikeCount;
    }

    public void setDynamiteLikeCount(Integer dynamiteLikeCount) {
        this.dynamiteLikeCount = dynamiteLikeCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}