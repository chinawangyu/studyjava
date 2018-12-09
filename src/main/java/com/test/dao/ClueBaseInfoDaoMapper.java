package com.test.dao;

import com.test.dataOject.ClueBaseInfoDao;
import java.util.List;

public interface ClueBaseInfoDaoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ClueBaseInfoDao record);

    ClueBaseInfoDao selectByPrimaryKey(Integer id);

    List<ClueBaseInfoDao> selectAll();

    int updateByPrimaryKey(ClueBaseInfoDao record);
}