package com.class1804.democustomer.Service.Customer_dynamic.impl;

import com.class1804.democustomer.Service.Customer_dynamic.Customer_dynamicService;
import com.class1804.democustomer.dao.Customer_dynamic.Customer_dynamicDao;
import com.class1804.democustomer.pojo.Customer_dynamic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Customer_dynamicServiceImpl implements Customer_dynamicService {

    @Autowired
    private Customer_dynamicDao customer_dynamicDao;

    @Override
    public int setdynamic(Customer_dynamic customer_dynamic) {
        return customer_dynamicDao.setdynamic(customer_dynamic);
    }

    @Override
    public int getcd_userid(int id) {
        return customer_dynamicDao.getcd_userid(id);
    }

    @Override
    public double getcd_usermoney(int id) {
        return customer_dynamicDao.getcd_usermoney(id);
    }


    @Override
    public List<Customer_dynamic> getList(Customer_dynamic customer_dynamic) {
        return customer_dynamicDao.getList(customer_dynamic);
    }

    @Override
    public List<Customer_dynamic> getMoneyList(int productId, int categoryId) {
        return customer_dynamicDao.getMoneyList(productId,categoryId);
    }
}
