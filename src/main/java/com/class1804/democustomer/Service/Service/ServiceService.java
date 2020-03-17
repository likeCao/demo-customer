package com.class1804.democustomer.Service.Service;

import org.apache.ibatis.annotations.Param;

public interface ServiceService {
    /*新增客户售后数据（客户、员工、产品必须是数据库中存在的）
     * 与客户预约添加类似，所需客户、员工、产品的信息方法预约表已实现
     * */
    int addService(@Param("service_content") String service_content,@Param("service_date") String service_date,
                   @Param("service_userid") Integer service_userid,@Param("service_situation") Integer service_situation,
                   @Param("service_productid") Integer service_productid,@Param("service_customerid") Integer service_customerid);

}
