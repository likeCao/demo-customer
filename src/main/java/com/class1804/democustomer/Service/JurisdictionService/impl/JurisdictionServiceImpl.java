package com.class1804.democustomer.Service.JurisdictionService.impl;


import com.class1804.democustomer.Service.JurisdictionService.JurisdictionService;
import com.class1804.democustomer.dao.JurisdictionDao.JurisdictionDao;
import com.class1804.democustomer.pojo.Customer;
import com.class1804.democustomer.pojo.Jurisdiction;
import com.class1804.democustomer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class JurisdictionServiceImpl implements JurisdictionService {
    @Autowired
    private JurisdictionDao jurisdictionDao;


    @Override
    public List<User> getUserJurisdiction() {
        return jurisdictionDao.getUserJurisdiction();
    }

    @Override
    public List<Customer> getCustomerJurisdiction() {
        return jurisdictionDao.getCustomerJurisdiction();
    }


    @Transactional(propagation= Propagation.REQUIRED)
    @Override
    public int addJurisdiction(Jurisdiction jurisdiction) {
        return jurisdictionDao.addJurisdiction(jurisdiction);
    }
}
