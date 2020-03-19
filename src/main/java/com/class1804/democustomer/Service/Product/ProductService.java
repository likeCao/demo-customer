package com.class1804.democustomer.Service.Product;

import com.class1804.democustomer.pojo.Product;

import java.util.List;

public interface ProductService {

    //新增产品
    int productAdd(Product product);

    //根据产品分类查询产品，返回符合规定的数据
    List<Product> getProductsByParam(Product product);

    //修改产品（根据金额等动态）
    int updateProduct(Product product);
}
