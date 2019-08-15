package com.xunru.service;

import com.xunru.model.User;

public interface UserService {
    Integer register(User record);

    User login(User record);
}
