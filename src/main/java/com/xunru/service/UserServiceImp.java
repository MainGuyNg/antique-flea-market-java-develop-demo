package com.xunru.service;

import com.xunru.dao.UserMapper;
import com.xunru.model.User;
import com.xunru.utils.SystemCurrentTimeUtil;
import com.xunru.utils.UUIDutil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service("userService")
public class UserServiceImp implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public Integer register(User record) {
        record.setRegisterTime(new Date(SystemCurrentTimeUtil.getCurrentDate()));
        record.setUserId(UUIDutil.getUUID());
        Integer result = userMapper.register(record);
        return result;
    }

    @Override
    public User login(User record) {
        User user = userMapper.login(record);
        record.setLoginTime(new Date(SystemCurrentTimeUtil.getCurrentDate()));
        userMapper.updateLoginTimeByOpenid(record);
        return user;
    }
}
