package com.class1804.democustomer.Service.Product_category.impl;

import com.class1804.democustomer.dao.Product_category.Product_categoryDao;
import com.class1804.democustomer.pojo.Product_category;
import com.class1804.democustomer.Service.Product_category.Product_categoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Product_categoryServiceImpl implements Product_categoryService {

    @Autowired
    private Product_categoryDao product_categoryDao;

    //新增产品类别
    @Override
    public int product_categoryAdd(Product_category product_category) {
        return product_categoryDao.product_categoryAdd(product_category);
    }

    //查询产品类别
    @Override
    public List<Product_category> getProduct_categorys(Product_category product_category) {
        return product_categoryDao.getProduct_categorys(product_category);
    }





}
