package com.xunru.service.implement;

import com.xunru.dao.FriendGroupMapper;
import com.xunru.model.FriendGroup;
import com.xunru.service.FriendGroupService;
import com.xunru.utils.SystemCurrentTimeUtil;
import com.xunru.utils.UUIDutil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("friendGroupService")
public class FriendGroupServiceImp implements FriendGroupService {

    @Resource
    FriendGroupMapper friendGroupMapper;

    @Override
    public Integer modifyFriendGroupInfo(FriendGroup record) {
        record.setUpdateTime(new Date(SystemCurrentTimeUtil.getCurrentDate()));
        int result = friendGroupMapper.modifyFriendGroupInfo(record);
        return result;
    }

    @Override
    public List<FriendGroup> queryFriendGroupByUserId(String userId) {
        List<FriendGroup> list = friendGroupMapper.queryFriendGroupByUserId(userId);
        return list;
    }

    @Override
    public Integer addFriendGroup(String userId, String groupName) {
        FriendGroup friendGroup = new FriendGroup();
        friendGroup.setGroupId(UUIDutil.getUUID());
        friendGroup.setUserId(userId);
        friendGroup.setGroupName(groupName);
        friendGroup.setCreateTime(new Date(SystemCurrentTimeUtil.getCurrentDate()));

        int result = friendGroupMapper.addFriendGroup(friendGroup);
        return result;
    }

    @Override
    public Integer deleteFriendGroup(String userId, String groupId) {
        int result = friendGroupMapper.deleteFriendGroup(userId,groupId);
        return result;
    }
}
