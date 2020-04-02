package com.class1804.democustomer.Service.ClueUpdate.impl;

import com.class1804.democustomer.Service.ClueUpdate.ClueUpdateService;
import com.class1804.democustomer.dao.ClueUpdate.ClueUpdateDao;
import com.class1804.democustomer.pojo.Clue;
import com.class1804.democustomer.pojo.ClueClueupdateinfo;
import com.class1804.democustomer.pojo.ClueUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClueUPdateServiceImpl implements ClueUpdateService {

    @Autowired
    private ClueUpdateDao clueUpdateDao ;

    @Override
    public ClueClueupdateinfo getClueInfoById(int id) {
        return clueUpdateDao.getClueInfoById(id);
    }

    @Override
    public int seClueUpdate(ClueUpdate clueUpdate) {
        return clueUpdateDao.seClueUpdate(clueUpdate);
    }

    @Override
    public int databaseClueUPdate(int id) {
        return clueUpdateDao.databaseClueUPdate(id);
    }
}
