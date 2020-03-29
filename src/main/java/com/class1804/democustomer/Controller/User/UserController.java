package com.class1804.democustomer.Controller.User;

import com.class1804.democustomer.Service.UserService.UserService;
import com.class1804.democustomer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //跳到登录页
    @GetMapping("/login")
    public String toLogin(){
        return "/login";
    }


    //处理登录
    @PostMapping("/doLogin")
    public String doLogin(Integer user_id, Integer user_password, HttpSession session, Model model){
        User user=userService.login(user_id,user_password);
        //登陆成功
        if(user!=null){
            session.setAttribute("loginUser",user);
            return "/dashboard";
        }else{
            //登陆失败
            String msg="用户名或密码不正确";
            model.addAttribute("msg",msg);
            return "/login";
        }

    }

    


}
