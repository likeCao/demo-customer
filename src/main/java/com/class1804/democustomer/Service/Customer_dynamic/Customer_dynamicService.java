package com.class1804.democustomer.Service.Customer_dynamic;

import com.class1804.democustomer.pojo.Customer_dynamic;

import java.util.List;

public interface Customer_dynamicService {

    //新增购买信息表（客户，员工，产品id必须是数据库存在的）
    int setdynamic(Customer_dynamic customer_dynamic);


    //根据员工id查询出一共有多少条购买信息以及所有购买信息的总金额
    List<Integer> getcd_userid(int id);

    //查询客户购买信息列表按照时间排序（模糊动态查询，按照员工id、客户id、产品id）
    List<Customer_dynamic> getList(Customer_dynamic customer_dynamic);
}
