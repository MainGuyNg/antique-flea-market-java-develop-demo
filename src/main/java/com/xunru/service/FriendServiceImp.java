package com.xunru.service;

import com.xunru.dao.FriendMapper;
import com.xunru.model.Friend;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("friendService")
public class FriendServiceImp implements FriendService {

    @Resource
    FriendMapper friendMapper;

    @Override
    public List<Friend> queryFriendListOrderByFriendRemark(String userId) {
        List<Friend> list = friendMapper.queryFriendListOrderByFriendRemark(userId);
        return list;
    }
}
