package com.class1804.democustomer.Controller.Customer_dynamic;

import com.class1804.democustomer.Service.Customer_dynamic.Customer_dynamicService;
import com.class1804.democustomer.pojo.Customer_dynamic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cd")
public class Customer_dynamicController {

    @Autowired
    private Customer_dynamicService customer_dynamicService;

    //添加购买信息
    @GetMapping("/set")
    public String setCustomer_dynamicService(){
        Customer_dynamic customer_dynamic = new Customer_dynamic();
        customer_dynamic.setCd_content("全新欧美风私人定制，要求46寸");
        customer_dynamic.setCd_customerid(5);
        customer_dynamic.setCd_userid(100001);
        customer_dynamic.setCd_productid(3);

        int count = customer_dynamicService.setdynamic(customer_dynamic);
        System.out.println("===================================================================");
        System.out.println(count);
        System.out.println("===================================================================");

        return "/login" ;
    }

    //查询总金额和购买次数
    @GetMapping("/count")
    public String countid(){
        int id = 100001 ;
        List<Integer> contList = customer_dynamicService.getcd_userid(id);
        System.out.println("===================================================================");
        System.out.println(contList);
        System.out.println("===================================================================");
        return "/login" ;
    }


    //查看列表
    @GetMapping("/list")
    public String getList(){
        Customer_dynamic customer_dynamic = new Customer_dynamic();
        customer_dynamic.setCd_id(100001);
        List<Customer_dynamic> list = customer_dynamicService.getList(customer_dynamic);
        System.out.println("===================================================================");
        for (Customer_dynamic cd : list){
            System.out.println(cd.toString());
        }
        System.out.println("===================================================================");
        return "/login";
    }


}
