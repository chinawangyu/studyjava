package com.test.service.impl;

import com.test.dao.ClueAuthLogDaoMapper;
import com.test.dataOject.ClueAuthLogDao;
import com.test.service.ClueAuthService;
import com.test.service.model.ClueAuthLogModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClueAuthServiceImpl implements ClueAuthService {

    @Autowired
    private ClueAuthLogDaoMapper clueAuthLogDaoMapper;

    public ClueAuthLogModel getInfo(Integer id) {
        ClueAuthLogDao clueAuthLogDao = clueAuthLogDaoMapper.selectByPrimaryKey(id);
        //也可以查询其他数据组装
        //todo

        return convertFromDataObject(clueAuthLogDao);
    }


    /**
     * dataObject转换成业务model
     */
    private ClueAuthLogModel convertFromDataObject(ClueAuthLogDao clueAuthLogDao) {
        if (clueAuthLogDao == null) {
            return null;
        }
        ClueAuthLogModel clueAuthLogModel = new ClueAuthLogModel();
        BeanUtils.copyProperties(clueAuthLogDao, clueAuthLogModel); //源的字段必须都包含到model里
        clueAuthLogModel.setExtend("额外的数据");
        return clueAuthLogModel;
    }
}
