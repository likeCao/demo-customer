package com.class1804.democustomer.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/*
* 这个controller是实现模块跳转的后期可删
* 前期勿删
* 后期可删
* 实现素材模块跳转
* ！！！！！！！！！！！！
* */
@Controller
public class Test {

    @RequestMapping({"/","/login"})
    public String tologin(){
        return "/login";
    }
    @RequestMapping("/editprofile")
    public String editprofile(){
        return "/thymeleaf/sorry";
    }
    @RequestMapping("/accountsettings")
    public String editprofile1(){
        return "/thymeleaf/sorry";
    }
    @RequestMapping("/help")
    public String editprofile2(){
        return "/thymeleaf/sorry";
    }
    @RequestMapping("/dashboard")
    public String dashboard(){
        return "/thymeleaf/dashboard";
    }@RequestMapping("/manageblog")
    public String manageblog(){
        return "/thymeleaf/manageblog";
    }@RequestMapping("/messages")
    public String messages(){
        return "/thymeleaf/messages";
    }@RequestMapping("/reports")
    public String reports(){
        return "/thymeleaf/reports";
    }@RequestMapping("/forms")
    public String forms(){
        return "/thymeleaf/forms";
    }@RequestMapping("/wizard")
    public String wizard(){
        return "/thymeleaf/wizard";
    }@RequestMapping("/editor")
    public String editor(){
        return "/thymeleaf/editor";
    }@RequestMapping("/elements")
    public String elements(){
        return "/thymeleaf/elements";
    }@RequestMapping("/widgets")
    public String widgets(){
        return "/thymeleaf/widgets";
    }@RequestMapping("/calendar")
    public String calendar(){
        return "/thymeleaf/calendar";
    }
    @RequestMapping("/support")
    public String support(){
        return "/thymeleaf/support";
    }
    @RequestMapping("/typography")
    public String typography(){
        return "/thymeleaf/typography";
    }
    @RequestMapping("/tables")
    public String tables(){
        return "/thymeleaf/tables";
    }
    @RequestMapping("/buttons")
    public String buttons(){
        return "/thymeleaf/buttons";
    }
    @RequestMapping("/notfound")
    public String notfound(){
        return "/thymeleaf/notfound";
    }
    @RequestMapping("/forbidden")
    public String forbidden(){
        return "/thymeleaf/forbidden";
    }
    @RequestMapping("/internal")
    public String internal(){
        return "/thymeleaf/internal";
    }
    @RequestMapping("/offline")
    public String offline(){
        return "/thymeleaf/offline";
    }
    @RequestMapping("/newsfeed")
    public String newsfeed(){
        return "/thymeleaf/newsfeed";
    }
    @RequestMapping("/profile")
    public String profile(){
        return "/thymeleaf/profile";
    }
    @RequestMapping("/productlist")
    public String productlist(){
        return "/thymeleaf/productlist";
    }
    @RequestMapping("/photo")
    public String photo(){
        return "/thymeleaf/photo";
    }
    @RequestMapping("/gallery")
    public String gallery(){
        return "/thymeleaf/gallery";
    }
    @RequestMapping("/invoice")
    public String invoice(){
        return "/thymeleaf/invoice";
    }







}
