package com.xunru.dao;

import com.xunru.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(String openid);

    int insert(User record);

    User selectByPrimaryKey(String openid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User login(User record);

    int register(User record);

    int updateLoginTimeByOpenid(User record);
}