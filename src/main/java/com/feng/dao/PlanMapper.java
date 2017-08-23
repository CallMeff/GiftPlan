package com.feng.dao;

import com.feng.entity.Plan;

import java.util.List;

public interface PlanMapper {
    int deleteByPrimaryKey(Long planId);

    int insert(Plan record);

    int insertSelective(Plan record);

    Plan selectByPrimaryKey(Long planId);

    List<Plan> selectAll();

    int updateByPrimaryKeySelective(Plan record);

    int updateByPrimaryKey(Plan record);
}