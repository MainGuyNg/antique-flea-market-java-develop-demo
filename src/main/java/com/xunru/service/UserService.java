package com.xunru.service;

import com.xunru.model.User;

import java.util.List;

public interface UserService {
    User selectUserByPrimaryKey(String userId);

    Integer register(User record);

    User login(User record);

    Integer updateUserInfo(User record);

    List<User> queryUserByNickname(String nickname);
}
