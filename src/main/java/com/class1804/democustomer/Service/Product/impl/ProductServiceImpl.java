package com.class1804.democustomer.Service.Product.impl;

import com.class1804.democustomer.dao.Product.ProductDao;
import com.class1804.democustomer.pojo.Product;
import com.class1804.democustomer.Service.Product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;


    //新增产品
    @Override
    public int productAdd(Product product) {
        return productDao.productAdd(product);
    }

    //根据产品分类查询产品，返回符合规定的数据
    @Override
    public List<Product> getProductsByParam(Product product) {
        return productDao.getProductsByParam(product);
    }

    //修改产品（根据金额等动态）
    @Override
    public int updateProduct(Product product) {
        return productDao.updateProduct(product);
    }


}
