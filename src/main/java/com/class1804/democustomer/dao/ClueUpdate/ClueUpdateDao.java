package com.class1804.democustomer.dao.ClueUpdate;

import org.apache.ibatis.annotations.Param;

public interface ClueUpdateDao {

    //新增线索更新
    int seClueUpdate(ClueUpdateDao clueUpdateDao);

    //删除线索更新
    int databaseClueUPdate(@Param("id")int id);
}
