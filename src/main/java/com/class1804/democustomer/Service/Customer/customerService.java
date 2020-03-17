package com.class1804.democustomer.Service.Customer;

import com.class1804.democustomer.pojo.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface customerService {

    //添加
    int setCustomer(Customer customer);

    //查询
    List<Customer> getCustomerList(Customer customer);

    //修改客户级别
    int updateCustomerJ(int id,int jurisdiction);

    //修改客户个人信息（不能修改姓名性别等重要基本信息）
    int updateCustomer(Customer customer);

    //查询客户数量（动态查询按照员工id、客户年龄段、客户性别）
    int customerCount(int id,int gender);
}
