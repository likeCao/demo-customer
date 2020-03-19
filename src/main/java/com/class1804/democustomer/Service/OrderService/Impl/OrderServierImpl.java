package com.class1804.democustomer.Service.OrderService.Impl;
import com.class1804.democustomer.Service.OrderService.OrderServer;
import com.class1804.democustomer.dao.OrderDao.OrderDao;
import com.class1804.democustomer.pojo.Customer;
import com.class1804.democustomer.pojo.Order;
import com.class1804.democustomer.pojo.Product;
import com.class1804.democustomer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Date;
@Service
public class OrderServierImpl implements OrderServer {

    @Autowired
    private OrderDao orderDao;

    /*查询客户表所有信息*/
    @Override
    public List<Customer> getCustomers() {
       return orderDao.getCustomers();
    }

    /*查询员工表所有信息*/
    @Override
    public List<User> getUsers() {
        return orderDao.getUsers();
    }
    /*查询商品表所有信息*/
    @Override
    public List<Product> getProducts() {
        return orderDao.getProducts();
    }
    /*新增预约客户*/
    @Override
    public int addOrder( Integer order_number, Integer order_customerid, Integer order_userid, Integer order_productid, String order_date, String order_text) {
        return orderDao.addOrder(order_number,order_customerid,order_userid,order_productid,order_date,order_text);
    }
    /*查询客户预约列表（按照客户id，员工id，时间，预约号）
     * 模糊查询
     * */
    @Override
    public List<Order> getOrderByciduid(Integer order_customerid, Integer order_userid, Date order_date, Integer order_number,Integer currentPageNo,Integer pageSize) {
        return orderDao.getOrderByciduid(order_customerid,order_userid,order_date,order_number,currentPageNo,pageSize);
    }
    /*修改（按照预约id进行修改备注和预约时间）*/
    @Override
    public int updateOrderByorderid(Order order) {
        return orderDao.updateOrderByorderid(order) ;
    }
    /*删除（根据预约id删除）*/
    @Override
    public int deleteOrderByorderid(Integer order_id) {
        return orderDao.deleteOrderByorderid(order_id);
    }

    /*获取客户预约数据总数
     * 用于分页判断总数和页数
     * */
    @Override
    public int selectorderall() {
        return orderDao.selectorderall();
    }



}
