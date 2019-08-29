package com.xunru.service;

import com.xunru.model.FriendGroup;

import java.util.List;

public interface FriendGroupService {
    Integer modifyFriendGroupInfo(FriendGroup record);

    List<FriendGroup> queryFriendGroupByUserId(String userId);

    FriendGroup queryFriendGroupByUserIdAndGroupName(String userId, String groupName);

    Integer addFriendGroup(String userId, String groupName);

    Integer deleteFriendGroup(String userId, String groupId);
}
