package com.class1804.democustomer.Service.ClueUpdate;

import com.class1804.democustomer.dao.ClueUpdate.ClueUpdateDao;

public interface ClueUpdateService {


    //新增线索更新
    int seClueUpdate(ClueUpdateDao clueUpdateDao);

    //删除线索更新
    int databaseClueUPdate(int id);
}
