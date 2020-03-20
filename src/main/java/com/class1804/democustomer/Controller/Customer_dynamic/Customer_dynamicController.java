package com.class1804.democustomer.Controller.Customer_dynamic;

import com.class1804.democustomer.Service.Customer_dynamic.Customer_dynamicService;
import com.class1804.democustomer.pojo.Customer_dynamic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sound.midi.Soundbank;
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
        customer_dynamic.setCd_customerid(6);
        customer_dynamic.setCd_userid(100005);
        customer_dynamic.setCd_productid(3);
        customer_dynamic.setCd_money(999);

        int count = customer_dynamicService.setdynamic(customer_dynamic);
        System.out.println("===================================================================");
        System.out.println(count);
        System.out.println("===================================================================");

        return "/login" ;
    }

    //查询购买次数
    @GetMapping("/count")
    public String countid(){
        int id = 100004 ;
        int  contList= customer_dynamicService.getcd_userid(id);
        System.out.println("===================================================================");
        System.out.println(contList);
        System.out.println("===================================================================");
        return "/login" ;
    }

    //查询总金额
    @GetMapping("/money")
    public String money(){
        int id = 100004 ;
        double  contList= customer_dynamicService.getcd_usermoney(id);
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


    // //查询出所有员工的业绩（销售总金额）按照金额排序（动态查询时间、产品、产品分类）
    @GetMapping("/moneyAll")
    public String getmoneyAll(){
        int product = 3 ;
        int id =0;
        List<Customer_dynamic> moneylist = customer_dynamicService.getMoneyList(product,id);
        System.out.println("===================================================================");
        for (Customer_dynamic cd : moneylist){
            System.out.println("金额"+cd.getCd_moneyAll());
            System.out.println("id"+cd.getCd_userid());
        }
        System.out.println("===================================================================");
        return "/login";
    }

}
