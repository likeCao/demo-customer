package com.class1804.democustomer.Service.Customer.impl;


import com.class1804.democustomer.Service.Customer.customerService;
import com.class1804.democustomer.dao.Customer.customerDao;
import com.class1804.democustomer.pojo.ClueCustomerUser;
import com.class1804.democustomer.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class customerServiceImpl implements customerService {

    @Autowired
    private customerDao cd;

    @Override
    public List<Customer> getCustomer() {
        return cd.getCustomer();
    }

    @Override
    public int setCustomer(Customer customer) {
        return cd.setCustomer(customer);
    }

    @Override
    public List<Customer> getCustomerList(Customer customer) {
        return cd.getCustomerList(customer);
    }

    @Override
    public int updateCustomerJ(int id, int jurisdiction) {
        return cd.updateCustomerJ(id,jurisdiction);
    }

    @Override
    public int updateCustomer(Customer customer) {
        return cd.updateCustomer(customer);
    }

    @Override
    public int customerCount(int id,int gender) {
        return cd.customerCount(id,gender);
    }

    @Override
    public List<ClueCustomerUser> selectClueCusUser(Integer customer_id, Integer user_id, Integer user_jurisdiction, String user_name, Integer customer_gender, String customer_name, Integer currentPageNo, Integer pageSize) {
        return cd.selectClueCusUser(customer_id,user_id,user_jurisdiction,user_name,customer_gender,customer_name,currentPageNo,pageSize);
    }

    @Override
    public Integer selectClueCusUserCount(Integer customer_id, Integer user_id, Integer user_jurisdiction, String user_name, Integer customer_gender, String customer_name) {
        return cd.selectClueCusUserCount(customer_id,user_id,user_jurisdiction,user_name,customer_gender,customer_name);
    }


    @Override
    public Customer selectCustomerByid(Integer customer_id) {
        return cd.selectCustomerByid(customer_id);
    }
}
