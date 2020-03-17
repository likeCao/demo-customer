package com.class1804.democustomer.Controller.Jurisdiction;

import com.class1804.democustomer.Service.JurisdictionService.JurisdictionService;
import com.class1804.democustomer.pojo.Customer;
import com.class1804.democustomer.pojo.Jurisdiction;
import com.class1804.democustomer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 级别表
 * 这个Controller是测试！！！！！！！！！！！！！
 * 这个Controller是测试！！！！！！！！！！！！！
 *  测试获取员工所有级别成功
 *  测试获取客户所有级别成功
 *  测试添加级别成功
 */

@Controller
@RequestMapping("/jur")
public class JurisdictionController {
    @Autowired
    private JurisdictionService jurisdictionService;

    //获取员工所有级别
    @GetMapping("/getUser")
    @ResponseBody
    public List<User> getUserJurisdiction(){
        return jurisdictionService.getUserJurisdiction();
    }

    //获取客户所有级别
    @GetMapping("/getCustomer")
    @ResponseBody
    public List<Customer> getCustomerJurisdiction(){
        return jurisdictionService.getCustomerJurisdiction();
    }


    //新增级别
    @GetMapping("/add")
    @ResponseBody
    public String addJurisdiction(){
        Jurisdiction  jurisdiction=new Jurisdiction();
        jurisdiction.setJ_classification(2);
        jurisdiction.setJ_name("钻1");
        int count=jurisdictionService.addJurisdiction(jurisdiction);
        System.out.println(count);
       return "/login";

    }

}
