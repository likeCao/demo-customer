package com.class1804.democustomer.dao.OrderDao;

import com.class1804.democustomer.pojo.Customer;
import com.class1804.democustomer.pojo.Order;
import com.class1804.democustomer.pojo.Product;
import com.class1804.democustomer.pojo.User;
import org.apache.ibatis.annotations.Param;
import java.util.Date;
import java.util.List;
/*客户预约表*/
public interface OrderDao {
    /*新增客户预约表（客户、员工、产品id是数据库必须存在的）*/
    /*先查询客户表，员工表，产品表所有数据
    * 新增预约客户时展示客户名字，员工名字，产品名字的下拉框
    * 获取前台参数：客户id,员工id，产品id
    * */
    /*查询客户表所有信息*/
    List<Customer> getCustomers ();
    /*查询员工表所有信息*/
    List<User> getUsers ();
    /*查询商品表所有信息*/
    List<Product> getProducts ();
    /*新增预约客户*/
    int addOrder( @Param("order_number") Integer order_number,
                 @Param("order_customerid") Integer order_customerid, @Param("order_userid") Integer order_userid,
                 @Param("order_productid") Integer order_productid, @Param("order_date") String order_date,
                 @Param("order_text") String order_text);

    /*查询客户预约列表（按照客户id，员工id，时间，预约号）
    * 模糊查询
    * */
    List<Order> getOrderByciduid(@Param("order_customerid") Integer order_customerid,@Param("order_userid") Integer order_userid,
                                 @Param("order_date") Date order_date,@Param("order_number") Integer order_number,
                                 @Param(value="from")Integer currentPageNo,
                                 @Param(value="pageSize")Integer pageSize);

    /*修改（按照预约id进行修改备注和预约时间）*/
    int updateOrderByorderid(Order order);

    /*删除（根据预约id删除）*/
    int deleteOrderByorderid(Integer order_id);

    /*获取客户预约数据总数
     * 用于分页判断总数和页数
     * */
    int selectorderall();


}
