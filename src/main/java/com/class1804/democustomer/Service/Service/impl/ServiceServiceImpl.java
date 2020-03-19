package com.class1804.democustomer.Service.Service.impl;

import com.class1804.democustomer.Service.Service.ServiceService;
import com.class1804.democustomer.dao.ServiceDao.ServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ServiceServiceImpl  implements ServiceService {
    @Autowired
   private ServiceDao serviceDao;

    /*新增客户售后数据（客户、员工、产品必须是数据库中存在的）
     * 与客户预约添加类似，所需客户、员工、产品的信息方法预约表已实现
     * */
    @Override
    public int addService(String service_content, String service_date, Integer service_userid, Integer service_situation, Integer service_productid, Integer service_customerid) {
        return serviceDao.addService(service_content,service_date,service_userid,service_situation,service_productid,service_customerid);
    }

    /*查询客户售后（动态查询按照客户姓名、员工id、售后评价、产品id）
     * 页面显示客户名，获取数据为客户id，类型搜索框
     * */
    @Override
    public List<com.class1804.democustomer.pojo.Service> selectService(String customer_name, Integer user_id, Integer service_situation, Integer product_id,Integer currentPageNo,Integer pageSize) {
        return serviceDao.selectService(customer_name,user_id,service_situation,product_id,currentPageNo,pageSize);
    }


    /*获取客户预约数据总数
     * 用于分页判断总数和页数
     * */
    @Override
    public int selectserviceall() {
        return serviceDao.selectserviceall();
    }
}
