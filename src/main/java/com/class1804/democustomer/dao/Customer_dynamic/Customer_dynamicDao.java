package com.class1804.democustomer.dao.Customer_dynamic;

import com.class1804.democustomer.pojo.Customer_dynamic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Customer_dynamicDao {

    //新增购买信息表（客户，员工，产品id必须是数据库存在的）
    int setdynamic(Customer_dynamic customer_dynamic);

    //根据员工id查询出一共有多少条购买信息
    int getcd_userid(int id);

    //查询客户购买信息列表按照时间排序（模糊动态查询，按照员工id、客户id、产品id）
    List<Customer_dynamic> getList(Customer_dynamic customer_dynamic);

    //根据员工id查询总金额
    double getcd_usermoney(int id);

    //查询出所有员工的业绩（销售总金额）按照金额排序（动态查询时间、产品、产品分类）
    List<Customer_dynamic> getMoneyList(@Param("productId") int productId, @Param("categoryId") int categoryId);
}

