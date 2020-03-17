package com.class1804.democustomer.Service.Customer.impl;


import com.class1804.democustomer.Service.Customer.customerService;
import com.class1804.democustomer.dao.Customer.customerDao;
import com.class1804.democustomer.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class customerServiceImpl implements customerService {

    @Autowired
    private customerDao cd;

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
}
