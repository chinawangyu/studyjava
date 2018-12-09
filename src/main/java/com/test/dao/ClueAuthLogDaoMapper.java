package com.test.dao;

import com.test.dataOject.ClueAuthLogDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClueAuthLogDaoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ClueAuthLogDao record);

    ClueAuthLogDao selectByPrimaryKey(Integer id);

    List<ClueAuthLogDao> selectAll();

    int updateByPrimaryKey(ClueAuthLogDao record);
}