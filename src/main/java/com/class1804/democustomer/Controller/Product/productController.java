package com.class1804.democustomer.Controller.Product;

import com.class1804.democustomer.pojo.Product;
import com.class1804.democustomer.Service.Product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/pro")
public class productController {

    @Autowired
    private ProductService productService;


    /*
    测试添加产品
     */
    @GetMapping("/productAdd")
    public String productAdd(){
        Product product=new Product();
        product.setProduct_name("婚纱照");
        product.setProduct_start("2019-03-04");
        product.setProduct_introduce("婚纱照");
        product.setProduct_category(1);
        product.setProduct_money(245.00);
        product.setProduct_cost(100.00);
        int count=productService.productAdd(product);
        System.out.println(count);
        return "/login";
    }

    /*
    测试查询
     */
    @GetMapping("/getProducts")
    public String getProductsByParam(){
        Product product=new Product();
        product.setProduct_category(1);
        List<Product> getProducts=productService.getProductsByParam(product);
        System.out.println(getProducts);
        return "/login";

    }

    /*
    测试修改产品金额
     */
    @GetMapping("/updateProduct")
    public String updateProduct(){
        Product product=new Product();
        product.setProduct_money(300.00);
        product.setProduct_introduce("照片");
        product.setProduct_id(4);
        int count=productService.updateProduct(product);
        System.out.println(count);
        return "/login";
    }




}
