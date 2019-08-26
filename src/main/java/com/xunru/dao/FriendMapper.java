package com.xunru.dao;

import com.xunru.model.Friend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FriendMapper {
    int deleteByPrimaryKey(String id);

    int insert(Friend record);

    int insertSelective(Friend record);

    Friend selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Friend record);

    int updateByPrimaryKey(Friend record);


    //自定义方法
    List<Friend> queryFriendListOrderByFriendRemark(@Param("userId") String userId);
}