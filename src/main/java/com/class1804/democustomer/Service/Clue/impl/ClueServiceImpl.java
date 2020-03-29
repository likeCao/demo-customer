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
    public List<Clue> getClueListByParams(Integer clue_userid, Integer clue_custome, Integer clue_product, PageUtil pu) {
        //mysql分页起始位置(当前页码-1)*一页显示条数
        int start = (pu.getCurrentPage()-1)*pu.getPageSize() ;
        int pageSize = pu.getPageSize() ;


        //需要知道总共分几页
        //能根据条件查询出总记录数
        int totalCount =clueDao.getClueCountByParams(clue_userid,clue_custome,clue_product) ;

        //一共分几页
        pu.setTotalCount(totalCount);


        List<Clue> clueList =clueDao.getClueByParams(clue_userid,clue_custome,clue_product,start,pageSize);

        return clueList ;
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
