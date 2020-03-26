package com.class1804.democustomer.Service.ClueUpdate.impl;

import com.class1804.democustomer.Service.ClueUpdate.ClueUpdateService;
import com.class1804.democustomer.dao.ClueUpdate.ClueUpdateDao;
import org.springframework.beans.factory.annotation.Autowired;

public class ClueUPdateServiceImpl implements ClueUpdateService {

    @Autowired
    private ClueUpdateDao clueUpdateDao ;

    @Override
    public int seClueUpdate(ClueUpdateDao clueUpdateDao) {
        return clueUpdateDao.seClueUpdate(clueUpdateDao);
    }

    @Override
    public int databaseClueUPdate(int id) {
        return clueUpdateDao.databaseClueUPdate(id);
    }
}
