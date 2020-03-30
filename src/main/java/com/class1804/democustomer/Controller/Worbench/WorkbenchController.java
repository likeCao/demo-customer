package com.class1804.democustomer.Controller.Worbench;

import com.class1804.democustomer.Service.Clue.ClueService;
import com.class1804.democustomer.Service.Customer.customerService;
import com.class1804.democustomer.Service.Customer_dynamic.Customer_dynamicService;
import com.class1804.democustomer.Service.NoticeService.NoticeService;
import com.class1804.democustomer.Service.UserService.UserService;
import com.class1804.democustomer.pojo.Customer_dynamic;
import com.class1804.democustomer.pojo.Notice;
import com.class1804.democustomer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Workbench")
public class WorkbenchController {


    @Autowired
    ThymeleafViewResolver thymeleafViewResolver;

    //购买信息(合同）
    @Autowired
    private Customer_dynamicService customer_dynamicService;

    @Autowired
    private UserService userService;


    @Autowired
    private ClueService clueService;

    @Autowired
    private com.class1804.democustomer.Service.Customer.customerService customerService ;

    @Autowired
    private NoticeService noticeService;


    //跳转到工作台
    @RequestMapping("/home")
    //Ajax需要
    //@ResponseBody
    public String getWorkbench(Model model, HttpSession session){

        User user =(User)session.getAttribute("loginUser");

        int id = user.getUser_id();
        //成交的合同数
        int dynamic = customer_dynamicService.getcd_userid(id);
        System.out.println("---------成交的合同数"+dynamic+"------------------------");
        model.addAttribute("dynamic",dynamic);

        //成交合同的总金额
        double money = customer_dynamicService.getcd_usermoney(id);
        System.out.println("---------成交合同的总金额"+money+"------------------------");
        double m = money/10000;
        session.setAttribute("usermoney",m);

        //线索数
        int clueCount = clueService.getCount(id,0);
        model.addAttribute("clueCount",clueCount);

        //获取客户数量
        int customercount = customerService.customerCount(id,3);
        model.addAttribute("CustomerCount",customercount);


        int moneys =0;
        //获取排行
        List<Customer_dynamic> moneyList = customer_dynamicService.getMoneyList(0,0);
        int i = 0 ;
        for(Customer_dynamic cm:moneyList){
            i++;
            if(cm.getCd_userid()==id){
                break;
            }
        }
        session.setAttribute("Ranking",i);

        model.addAttribute("moneyList",moneyList);


        //获取购买列表
        Customer_dynamic customer_dynamic = new Customer_dynamic();
        customer_dynamic.setCd_userid(id);
        List<Customer_dynamic> getList = customer_dynamicService.getList(customer_dynamic);
        model.addAttribute("customerList",getList);

        //获取公告栏
        List<Notice> noticeList = noticeService.selectnotice(5,0,5);
        model.addAttribute("noticeList",noticeList);
        Notice notice=noticeList.get(0);
        model.addAttribute("notice",notice);

        return  "/Workbench";
    }

}
