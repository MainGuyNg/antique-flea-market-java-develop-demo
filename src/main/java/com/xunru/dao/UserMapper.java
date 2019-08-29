package com.xunru.dao;

import com.xunru.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


    //自定义方法
    User login(User record);

    int register(User record);

    int updateLoginTimeByOpenid(User record);

    int updateUserInfo(User record);

    List<User> queryUserByNickname(@Param("nickname") String nickname);
}