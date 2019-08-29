package com.xunru.service.implement;

import com.xunru.dao.FriendMapper;
import com.xunru.model.Friend;
import com.xunru.model.FriendGroup;
import com.xunru.service.FriendGroupService;
import com.xunru.service.FriendService;
import com.xunru.utils.SystemCurrentTimeUtil;
import com.xunru.utils.UUIDutil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("friendService")
public class FriendServiceImp implements FriendService {

    @Resource
    FriendMapper friendMapper;
    @Resource
    FriendGroupService friendGroupService;

    //由于没有设置按groupId查找好友列表，这里用userId查询
    @Override
    public List<Friend> queryFriendListByUserIdOrderByFriendRemark(String userId) {
        List<Friend> list = friendMapper.queryFriendListOrderByFriendRemark(userId);
        return list;
    }

    @Override
    public Integer addFriend(String userId, String friendId, String friendRemark) {
        FriendGroup friendGroup = friendGroupService.queryFriendGroupByUserIdAndGroupName(userId, "我的关注");

        Friend friend = new Friend();
        friend.setId(UUIDutil.getUUID());
        friend.setUserId(userId);
        friend.setFriendId(friendId);
        friend.setFriendRemark(friendRemark);
        friend.setFriendGroupId(friendGroup.getGroupId());
        friend.setCreateTime(new Date(SystemCurrentTimeUtil.getCurrentDate()));

        int result = friendMapper.addFriend(friend);

        return result;
    }

    @Override
    public Friend queryFriendInfoByUserIdAndFriendId(String userId, String friendId) {
        Friend friend = friendMapper.queryFriendInfoByUserIdAndFriendId(userId, friendId);
        return friend;
    }
}
