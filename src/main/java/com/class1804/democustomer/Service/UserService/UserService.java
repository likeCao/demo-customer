package com.class1804.democustomer.Service.UserService;

import com.class1804.democustomer.pojo.User;

import java.util.List;


public interface UserService {
    //获取员工列表
    List<User> getUserList();

    //根据id和password判断用户是否存在，返回该用户的全部数据(登录时获取)
    User login(Integer user_id, Integer user_password);

    //添加新员工
    int addUser(User user);

    //修改员工信息
    int editUser(User user);

}
