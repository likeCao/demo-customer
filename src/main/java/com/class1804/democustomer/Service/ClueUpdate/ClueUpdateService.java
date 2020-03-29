package com.class1804.democustomer.Service.ClueUpdate;

import com.class1804.democustomer.dao.ClueUpdate.ClueUpdateDao;
import com.class1804.democustomer.pojo.ClueUpdate;

public interface ClueUpdateService {
    //根据id获取线索信息
    ClueUpdate getClueInfoById(int id);


    //新增线索更新
    int seClueUpdate(ClueUpdate clueUpdate);

    //删除线索更新
    int databaseClueUPdate(int id);
}
