package com.xunru.model;

import java.util.Date;

public class Friend {
    private String id;

    private String userId;

    private String friendId;

    private String friendRemark;

    private String friendGroupId;

    private String isSpecialAttention;

    private Date createTime;

    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId == null ? null : friendId.trim();
    }

    public String getFriendRemark() {
        return friendRemark;
    }

    public void setFriendRemark(String friendRemark) {
        this.friendRemark = friendRemark == null ? null : friendRemark.trim();
    }

    public String getFriendGroupId() {
        return friendGroupId;
    }

    public void setFriendGroupId(String friendGroupId) {
        this.friendGroupId = friendGroupId == null ? null : friendGroupId.trim();
    }

    public String getIsSpecialAttention() {
        return isSpecialAttention;
    }

    public void setIsSpecialAttention(String isSpecialAttention) {
        this.isSpecialAttention = isSpecialAttention == null ? null : isSpecialAttention.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}