package com.class1804.democustomer.Service.Clue.impl;

import com.class1804.democustomer.Service.Clue.ClueService;
import com.class1804.democustomer.dao.Clue.ClueDao;
import com.class1804.democustomer.pojo.Clue;
import com.class1804.democustomer.tools.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClueServiceImpl implements ClueService {

    @Autowired
    private ClueDao clueDao;

    @Override
    public List<Clue> getClue() {
        return clueDao.getClue();
    }


    @Override
    public int getClueCountByParams(Integer clue_id, Integer clue_userid, Integer user_jurisdiction, Integer clue_product, Integer clue_custome) {
      return clueDao.getClueCountByParams(clue_id,clue_userid,user_jurisdiction,clue_product,clue_custome);
    }

    @Override
    public List<Clue> getClueListByParams(Integer clue_id,Integer clue_userid, Integer clue_custome, Integer clue_product,Integer user_jurisdiction,Integer start,Integer pageSize) {

        return clueDao.getClueByParams( clue_id,clue_userid,clue_custome,clue_product,user_jurisdiction,start,pageSize);


    }

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
