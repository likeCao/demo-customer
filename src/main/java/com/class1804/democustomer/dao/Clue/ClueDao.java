package com.class1804.democustomer.dao.Clue;

import com.class1804.democustomer.pojo.Clue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClueDao {
    //获取线索列表
    List<Clue> getClue();

    //根据负责人，客户，产品查询，返回满足条件的列表
    List<Clue> getClueByParams(@Param("clue_userid")Integer clue_userid, @Param("clue_custome")Integer clue_custome,@Param("clue_product")Integer clue_product, @Param("start")int start, @Param("pageSize")int pageSize) ;

    //根据负责人，客户，产品查询返回总记录数
    int getClueCountByParams(@Param("clue_userid")Integer clue_userid, @Param("clue_custome")Integer clue_custome,@Param("clue_product")Integer clue_product) ;



    //新增线索（客户、员工、产品id必须是数据库存在的）
    int setClue(Clue clue);

    //删除线索，根据id删除
    int databaseClue(@Param("id") int id);

    //查询出线索数据，按照时间排序（模糊动态查询，客户id，员工id、产品id）
    List<Clue> getClueList(Clue clue);



    //查询线索数量
    int getCount(@Param("userid") int userid,@Param("productid") int productid);


}
