package com.class1804.democustomer.dao.Customer;

import com.class1804.democustomer.pojo.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface customerDao {

    //新增客户（员工id必须是数据库中存在的）
    int setCustomer(Customer customer);

    //查询出客户列表（模糊动态查询，按照客户级别、性别、姓名、员工id）
    List<Customer> getCustomerList(Customer customer);

    //修改客户级别
    int updateCustomerJ(@Param("id") int id,@Param("jurisdiction") int jurisdiction);

    //修改客户个人信息（不能修改姓名性别等重要基本信息）
    int updateCustomer(Customer customer);

    //查询客户数量（动态查询按照员工id、客户年龄段、客户性别）
    int customerCount(@Param("id") int id,@Param("gender") int gender);

}
