package com.class1804.democustomer.dao.ClueUpdate;

import com.class1804.democustomer.pojo.Clue;
import com.class1804.democustomer.pojo.ClueClueupdateinfo;
import com.class1804.democustomer.pojo.ClueUpdate;
import org.apache.ibatis.annotations.Param;

public interface ClueUpdateDao {
    //根据id获取线索信息
    ClueClueupdateinfo getClueInfoById(int id);

    //新增线索更新
    int seClueUpdate(ClueUpdate clueUpdate);

    //删除线索更新
    int databaseClueUPdate(@Param("id")int id);
}
