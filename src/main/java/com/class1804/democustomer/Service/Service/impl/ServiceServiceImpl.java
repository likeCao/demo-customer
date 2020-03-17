package com.class1804.democustomer.Service.Service.impl;

import com.class1804.democustomer.Service.Service.ServiceService;
import com.class1804.democustomer.dao.ServiceDao.ServiceDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ServiceServiceImpl  implements ServiceService {
    @Resource
   private ServiceDao serviceDao;

    /*新增客户售后数据（客户、员工、产品必须是数据库中存在的）
     * 与客户预约添加类似，所需客户、员工、产品的信息方法预约表已实现
     * */
    @Override
    public int addService(String service_content, String service_date, Integer service_userid, Integer service_situation, Integer service_productid, Integer service_customerid) {
        return serviceDao.addService(service_content,service_date,service_userid,service_situation,service_productid,service_customerid);
    }
}
