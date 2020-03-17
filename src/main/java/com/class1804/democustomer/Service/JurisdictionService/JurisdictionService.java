package com.class1804.democustomer.Service.JurisdictionService;

import com.class1804.democustomer.pojo.Customer;
import com.class1804.democustomer.pojo.Jurisdiction;
import com.class1804.democustomer.pojo.User;

import java.util.List;

public interface JurisdictionService {
    //获取员工所有级别
    List<User> getUserJurisdiction();

    //获取客户所有级别
    List<Customer> getCustomerJurisdiction();

    //新增级别
    int addJurisdiction(Jurisdiction jurisdiction);


}
