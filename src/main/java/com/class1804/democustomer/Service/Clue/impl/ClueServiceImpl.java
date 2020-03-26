package com.class1804.democustomer.Service.Clue.impl;

import com.class1804.democustomer.Service.Clue.ClueService;
import com.class1804.democustomer.dao.Clue.ClueDao;
import com.class1804.democustomer.pojo.Clue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClueServiceImpl implements ClueService {

    @Autowired
    private ClueDao clueDao;

    @Override
    public int setClue(Clue clue) {
        return clueDao.setClue(clue);
    }

    @Override
    public List<Clue> getClueList(Clue clue) {
        return clueDao.getClueList(clue);
    }

    @Override
    public int databaseClue(int id) {
        return clueDao.databaseClue(id);
    }

    @Override
    public int getCount(int userid, int productid) {
        return clueDao.getCount(userid,productid);
    }

}
