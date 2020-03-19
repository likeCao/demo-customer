package com.class1804.democustomer.dao.Product;

import com.class1804.democustomer.pojo.Product;

import java.util.List;

public interface ProductDao {

    //新增产品
    int productAdd(Product product);

    //根据产品分类查询产品，返回符合规定的数据
    List<Product> getProductsByParam(Product product);

    //修改产品（按照金额等动态）
    int updateProduct(Product product);
}
