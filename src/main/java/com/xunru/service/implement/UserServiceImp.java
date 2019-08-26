package com.xunru.service.implement;

import com.xunru.dao.FriendGroupMapper;
import com.xunru.dao.UserMapper;
import com.xunru.model.FriendGroup;
import com.xunru.model.User;
import com.xunru.service.UserService;
import com.xunru.utils.SystemCurrentTimeUtil;
import com.xunru.utils.UUIDutil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service("userService")
public class UserServiceImp implements UserService {

    @Resource
    UserMapper userMapper;
    @Resource
    FriendGroupMapper friendGroupMapper;

    @Override
    public User selectUserByPrimaryKey(String userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        return user;
    }

    @Override
    public Integer register(User record) {
        record.setRegisterTime(new Date(SystemCurrentTimeUtil.getCurrentDate()));
        record.setUserId(UUIDutil.getUUID());
        Integer result = userMapper.register(record);
        if (result != 0) {
            FriendGroup friendGroup = new FriendGroup();
            friendGroup.setGroupId(UUIDutil.getUUID());
            friendGroup.setUserId(record.getUserId());
            friendGroup.setGroupName("我的关注");
            friendGroup.setCreateTime(new Date(SystemCurrentTimeUtil.getCurrentDate()));
            System.out.println(record.getNickname() + "成功新增" + friendGroupMapper.insertSelective(friendGroup) + "个分组:" + friendGroup.getGroupName());
            friendGroup.setGroupId(UUIDutil.getUUID());
            friendGroup.setGroupName("特别关注");
            System.out.println(record.getNickname() + "成功新增" + friendGroupMapper.insertSelective(friendGroup) + "个分组:" + friendGroup.getGroupName());
        }
        return result;
    }

    @Override
    public User login(User record) {
        User user = userMapper.login(record);
        if (user != null) {
            user.setLoginTime(new Date(SystemCurrentTimeUtil.getCurrentDate()));
            userMapper.updateLoginTimeByOpenid(user);
        }
        return user;
    }

    @Override
    public Integer updateUserInfo(User record) {
        record.setModifyTime(new Date(SystemCurrentTimeUtil.getCurrentDate()));
        Integer result = userMapper.updateUserInfo(record);
        return result;
    }
}
