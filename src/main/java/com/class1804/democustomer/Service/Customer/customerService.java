package com.class1804.democustomer.Service.Customer;

import com.class1804.democustomer.pojo.ClueCustomerUser;
import com.class1804.democustomer.pojo.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface customerService {
    //获取客户列表
    List<Customer> getCustomer();

    //添加
    int setCustomer(Customer customer);

    //查询
    List<Customer> getCustomerList(Customer customer);

    //修改客户级别
    int updateCustomerJ(int id,int jurisdiction);

    //修改客户个人信息（不能修改姓名性别等重要基本信息）
    int updateCustomer(Customer customer);

    //查询客户数量（动态查询按照员工id、客户年龄段、客户性别）
    int customerCount(int id,int gender);

    /*功能新增*/
    /*连表查询：列表显示姓名，电话，跟进时间，跟进状态，备注，负责人等信息
     * 条件有：用户id，负责人名字，跟进时间，用户等级
     * */
    List<ClueCustomerUser> selectClueCusUser(@Param("user_id") Integer user_id, @Param("user_jurisdiction") Integer user_jurisdiction,
                                            @Param("clue_date") String clue_date, @Param("user_name") String user_name,
                                            @Param(value="from")Integer currentPageNo,
                                            @Param(value="pageSize")Integer pageSize);

}
