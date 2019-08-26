package com.xunru.service;

import com.xunru.model.Friend;

import java.util.List;

public interface FriendService {
    List<Friend> queryFriendListOrderByFriendRemark(String userId);
}
