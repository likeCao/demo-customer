package com.class1804.democustomer.Controller.User;

import com.class1804.democustomer.Service.UserService.UserService;
import com.class1804.democustomer.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 员工表
 * 这个Controller是测试！！！！！！！！！！！！！
 * 这个Controller是测试！！！！！！！！！！！！！
 *  测试登录成功
 *  测试添加新员工成功
 *  测试修改员工信息成功
 */
@RequestMapping("/User")
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    //根据id和password判断用户是否存在，返回该用户的全部数据(登录时获取)
    @GetMapping("/UserLogin")
    @ResponseBody
    public User login(@Param("user_id") Integer user_id, @Param("user_password") Integer user_password){
        return userService.login(user_id,user_password);
    }

    //添加新员工
    @GetMapping("/addUser")
    @ResponseBody
    public String addUser(){
        User user=new User();
        user.setUser_name("小明");
        user.setUser_gender(1);
        user.setUser_birthday("19990529");
        user.setUser_jurisdiction(1);
        user.setUser_number("15231421259");
        user.setUser_address("河北省承德市");
        user.setUser_money(10000.00);
        user.setUser_password(19990529);
        Date time=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String date=sdf.format(time);
        user.setUser_entry(date);
        int count=userService.addUser(user);
        System.out.println(count);
        if (count==1){
            return "添加成功！";
        }else{
            return "失败！";
        }

    }

    //修改员工信息
    @GetMapping("/editUser")
    @ResponseBody
    public String editUser(){
        User user=new User();
        user.setUser_id(100004);
        user.setUser_name("小方");
        user.setUser_gender(0);
        user.setUser_birthday("19990529");
        user.setUser_jurisdiction(1);
        user.setUser_number("15231421259");
        user.setUser_address("河北省承德市");
        user.setUser_money(10000.00);
        user.setUser_password(19990529);
        user.setUser_entry("2020-03-05 ");
        int count=userService.editUser(user);
        if (count==1){
            return "修改成功";
        }else{
            return "修改失败";
        }
    }



}
