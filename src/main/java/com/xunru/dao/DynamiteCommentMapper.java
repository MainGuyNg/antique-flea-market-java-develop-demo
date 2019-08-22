package com.xunru.dao;

import com.xunru.model.DynamiteComment;

public interface DynamiteCommentMapper {
    int deleteByPrimaryKey(String id);

    int insert(DynamiteComment record);

    int insertSelective(DynamiteComment record);

    DynamiteComment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DynamiteComment record);

    int updateByPrimaryKey(DynamiteComment record);
}