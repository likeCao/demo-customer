package com.class1804.democustomer.Service.Service;

import com.class1804.democustomer.pojo.Service;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ServiceService {
    /*新增客户售后数据（客户、员工、产品必须是数据库中存在的）
     * 与客户预约添加类似，所需客户、员工、产品的信息方法预约表已实现
     * */
    int addService(@Param("service_content") String service_content,@Param("service_date") String service_date,
                   @Param("service_userid") Integer service_userid,@Param("service_situation") Integer service_situation,
                   @Param("service_productid") Integer service_productid,@Param("service_customerid") Integer service_customerid);

    /*查询客户售后（动态查询按照客户姓名、员工id、售后评价、产品id）
     * 页面显示客户名，获取数据为客户id，类型搜索框
     * */
    List<Service> selectService(@Param("customer_name") String customer_name,@Param("user_id") Integer user_id,
                                @Param("service_situation") Integer service_situation,@Param("product_id") Integer product_id,
                                @Param(value="from")Integer currentPageNo,
                                @Param(value="pageSize")Integer pageSize);


}
