package com.xunru.model;

import java.util.Date;

public class DynamiteComment {
    private String id;

    private String dynamiteCommentId;

    private String dynamiteMessageId;

    private String commentUserId;

    private String commentUserName;

    private String commentContent;

    private Integer dynamiteLikeCount;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDynamiteCommentId() {
        return dynamiteCommentId;
    }

    public void setDynamiteCommentId(String dynamiteCommentId) {
        this.dynamiteCommentId = dynamiteCommentId == null ? null : dynamiteCommentId.trim();
    }

    public String getDynamiteMessageId() {
        return dynamiteMessageId;
    }

    public void setDynamiteMessageId(String dynamiteMessageId) {
        this.dynamiteMessageId = dynamiteMessageId == null ? null : dynamiteMessageId.trim();
    }

    public String getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(String commentUserId) {
        this.commentUserId = commentUserId == null ? null : commentUserId.trim();
    }

    public String getCommentUserName() {
        return commentUserName;
    }

    public void setCommentUserName(String commentUserName) {
        this.commentUserName = commentUserName == null ? null : commentUserName.trim();
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
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