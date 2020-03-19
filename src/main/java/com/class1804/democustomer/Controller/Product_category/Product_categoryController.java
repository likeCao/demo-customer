package com.class1804.democustomer.Controller.Product_category;

import com.class1804.democustomer.pojo.Product_category;
import com.class1804.democustomer.Service.Product_category.Product_categoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/pc")
public class Product_categoryController {

    @Autowired
    private Product_categoryService product_categoryService;

    //新增产品类别
    @GetMapping("/pcAdd")
    public String product_categoryAdd(){
        Product_category product_category=new Product_category();
        product_category.setPc_name("婚纱");
        int count=product_categoryService.product_categoryAdd(product_category);
        System.out.println(count);
        return "/login";
    }

    //查询产品类别
    @GetMapping("/getpc")
    public String getProduct_categorys(){
        Product_category product_category=new Product_category();
        product_category.setPc_id(1);
        List<Product_category> product_categories=product_categoryService.getProduct_categorys(product_category);
        System.out.println(product_categories);
        return "/login";
    }
}
