package com.xunru.dao;

import com.xunru.model.FriendGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FriendGroupMapper {
    int deleteByPrimaryKey(String groupId);

    int insert(FriendGroup record);

    int insertSelective(FriendGroup record);

    FriendGroup selectByPrimaryKey(String groupId);

    int updateByPrimaryKeySelective(FriendGroup record);

    int updateByPrimaryKey(FriendGroup record);


    //自定义方法
    int modifyFriendGroupInfo(FriendGroup record);

    List<FriendGroup> queryFriendGroupByUserId(@Param("userId") String userId);

    int addFriendGroup(FriendGroup record);

    int deleteFriendGroup(@Param("userId") String userId, @Param("groupId") String groupId);

    FriendGroup queryFriendGroupByUserIdAndGroupName(@Param("userId") String userId, @Param("groupName") String groupName);
}