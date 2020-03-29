package com.class1804.democustomer.Service.Clue;

import com.class1804.democustomer.pojo.Clue;
import com.class1804.democustomer.tools.PageUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClueService {
    //获取线索列表
    List<Clue> getClue();

    //根据当前页码和条件获取线索列表
    List<Clue> getClueListByParams(Integer clue_userid,Integer clue_custome,Integer clue_product, PageUtil pu) ;


    //新增线索（客户、员工、产品id必须是数据库存在的）
    int setClue(Clue clue);

    //查询出线索数据，按照时间排序（模糊动态查询，客户id，员工id、产品id）
    List<Clue> getClueList(Clue clue);

    //删除线索，根据id删除
    int databaseClue( int id);

    //查询线索数量
    int getCount(int userid,int productid);


}
