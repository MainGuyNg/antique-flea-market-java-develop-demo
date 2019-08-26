package com.xunru.service;

import com.xunru.model.User;

public interface UserService {
    User selectUserByPrimaryKey(String userId);

    Integer register(User record);

    User login(User record);

    Integer updateUserInfo(User record);
}
