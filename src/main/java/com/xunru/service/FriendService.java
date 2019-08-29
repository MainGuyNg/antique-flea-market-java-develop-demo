package com.xunru.service;

import com.xunru.model.Friend;

import java.util.List;

public interface FriendService {
    List<Friend> queryFriendListByUserIdOrderByFriendRemark(String userId);

    Integer addFriend(String userId, String friendId, String friendRemark);

    Friend queryFriendInfoByUserIdAndFriendId(String userId, String friendId);
}
