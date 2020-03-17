package com.class1804.democustomer.Service.UserService.impl;


import com.class1804.democustomer.Service.UserService.UserService;
import com.class1804.democustomer.dao.UserDao.UserDao;
import com.class1804.democustomer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService {
   @Autowired
   private UserDao userDao;

    @Override
    public User login(Integer user_id, Integer user_password) {
        return userDao.login(user_id,user_password);
    }

    @Transactional(propagation= Propagation.REQUIRED)
    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Transactional(propagation= Propagation.REQUIRED)
    @Override
    public int editUser(User user) {
        return userDao.editUser(user);
    }
}
