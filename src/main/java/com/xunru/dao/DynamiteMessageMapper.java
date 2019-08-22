package com.xunru.dao;

import com.xunru.model.DynamiteMessage;

public interface DynamiteMessageMapper {
    int deleteByPrimaryKey(String id);

    int insert(DynamiteMessage record);

    int insertSelective(DynamiteMessage record);

    DynamiteMessage selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DynamiteMessage record);

    int updateByPrimaryKey(DynamiteMessage record);
}