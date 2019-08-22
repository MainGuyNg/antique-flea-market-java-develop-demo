package com.xunru.dao;

import com.xunru.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);



    User login(User record);

    int register(User record);

    int updateLoginTimeByOpenid(User record);
}