package com.class1804.democustomer.Controller.Marketing;

import com.class1804.democustomer.pojo.Marketing;
import com.class1804.democustomer.Service.MarketingService.MarketingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/mk")
public class MarketingController {

    @Autowired
    private MarketingService marketingService;


    //新增营销
    @GetMapping("/marketingAdd")
    public String marketingAdd(){
        Marketing marketing=new Marketing();
        marketing.setMarketing_start("2109-11-23");
        marketing.setMarketing_stop("2019-12-01");
        marketing.setMaeketing_name("八折");
        marketing.setMarketing_userid(100004);
        marketing.setMarketing_introduce("八折促销");
        marketing.setMarketing_money(1000.00);
        marketing.setMarketing_product(3);
        marketing.setMarketing_promoney(800.00);
        int count=marketingService.marketingAdd(marketing);
        System.out.println(count);
        return "/login";
    }

    //查询营销列表，按照时间排序（负责人、产品）
    @GetMapping("/getMarketings")
    public String getMarketings(){
        Marketing marketing=new Marketing();
        marketing.setMarketing_userid(1);
        marketing.setMarketing_product(1);
        List<Marketing> Marketings=marketingService.getMarketings(marketing);
        System.out.println(Marketings);
        return "/login";
    }

    //修改营销列表，按照营销id
    @GetMapping("updateMarketing")
    public String updateMarketingByMarketing_id(){
        Marketing marketing=new Marketing();
        marketing.setMarketing_stop("2020-1-22");
        marketing.setMaeketing_name("七折");
        marketing.setMarketing_introduce("七折促销");
        marketing.setMarketing_money(1000.00);
        marketing.setMarketing_product(2);
        marketing.setMarketing_promoney(700.00);
        marketing.setMarketing_id(1);
        int count=marketingService.updateMarketingByMarketing_id(marketing);
        System.out.println(count);
        return "/login";
    }

}
