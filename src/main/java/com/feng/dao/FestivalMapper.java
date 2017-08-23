package com.feng.dao;

import com.feng.entity.Festival;

import java.util.List;

public interface FestivalMapper {
    int deleteByPrimaryKey(Integer festivalId);

    int insert(Festival record);

    int insertSelective(Festival record);

    Festival selectByPrimaryKey(Integer festivalId);

    List<Festival> selectAll();

    int updateByPrimaryKeySelective(Festival record);

    int updateByPrimaryKey(Festival record);
}