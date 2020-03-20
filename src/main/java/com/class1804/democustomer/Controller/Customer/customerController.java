package com.class1804.democustomer.Controller.Customer;

import com.class1804.democustomer.Service.Customer.customerService;
import com.class1804.democustomer.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * 客户测试controller
 */
@Controller
@RequestMapping("/customer")
public class customerController {


    @Autowired
    private customerService cs;

    /**
     * 测试添加
     */
    @GetMapping("/set")
    public String setCustomer(){
        Customer customer = new Customer();
        customer.setCustomer_name("李四");
        customer.setCustomer_gender(1);
        customer.setCustomer_number("15732171602");
        customer.setCustomer_userid(100004);
        customer.setCustomer_money(0);
        customer.setCustomer_jurisdiction(7);
        customer.setCustomer_address("石家庄");
        customer.setCustomer_birthday("2019-2-11");
        customer.setCustomer_text("12346");

        int count =  cs.setCustomer(customer) ;

        System.out.println(count);

        return "/login";
    }


    /**
     * 测试查询列表
     * 客户级别、性别、姓名、员工id、客户id
     */
    @GetMapping("/get")
    public String getCustomerList(){
        Customer customer = new Customer();
        //customer.setCustomer_name("李");
        customer.setCustomer_id(1);
        List<Customer> customerList = cs.getCustomerList(customer);

        System.out.println("数据==============================================================="+customerList);
        return "/commons/left" ;
    }

    /**
     * 修改客户级别
     */
    @GetMapping("/updatej")
    public String updateCustomerJ(){
        int id = 5 ;
        int jurisdiction = 7 ;
        int count = cs.updateCustomerJ(id,jurisdiction) ;
        System.out.println("=============================================================================");
        System.out.println(count);
        System.out.println("=============================================================================");
        return "/login" ;
    }

    /**
     * 修改个人信息
     */
    @GetMapping("/update")
    public String updateCustomer(){
        Customer customer = new Customer() ;
        customer.setCustomer_text("帅气逼人");
        customer.setCustomer_id(5);
        int count = cs.updateCustomer(customer);
        System.out.println("=============================================================================");
        System.out.println(count);
        System.out.println("=============================================================================");
        return "/login";
    }

    /**
     * 查询人数
     */
    @GetMapping("/count")
    public String customerCount(){
        int id = 0 ;
        int gender =-1 ;
        int count =cs.customerCount(id,gender) ;
        System.out.println("=============================================================================");
        System.out.println(count);
        System.out.println("=============================================================================");
        return "/login";
    }
}
