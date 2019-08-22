package com.xunru.dao;

import com.xunru.model.FriendGroup;

public interface FriendGroupMapper {
    int deleteByPrimaryKey(String id);

    int insert(FriendGroup record);

    int insertSelective(FriendGroup record);

    FriendGroup selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FriendGroup record);

    int updateByPrimaryKey(FriendGroup record);
}