package com.class1804.democustomer.dao.Product_category;

import com.class1804.democustomer.pojo.Product_category;

import java.util.List;

public interface Product_categoryDao {

    //新增产品类别
    int product_categoryAdd(Product_category product_category);

    //查询产品类别
    List<Product_category> getProduct_categorys(Product_category product_category);
}
