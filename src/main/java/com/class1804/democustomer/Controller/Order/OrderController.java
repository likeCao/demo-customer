package com.class1804.democustomer.Controller.Order;

import com.class1804.democustomer.Service.OrderService.OrderServer;
import com.class1804.democustomer.pojo.Customer;
import com.class1804.democustomer.pojo.Order;
import com.class1804.democustomer.pojo.Product;
import com.class1804.democustomer.pojo.User;
import com.class1804.democustomer.tools.PageSupport;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/*客户预约表
*这个Controller是测试！！！！！！！！！！！！！
* 这个Controller是测试！！！！！！！！！
* 测试获取客户列表成功
* 测试获取用户列表成功
* 测试获取商品列表成功
* 测试添加预约信息成功
* 测试查询客户预约列表成功
* 测试按照预约id进行修改备注和预约时间成功
* 测试 根据预约id删除）成功
* */
@Controller
@RequestMapping("/Order")
public class OrderController {
    @Autowired
    private OrderServer orderServer;

    /*获取客户列表*/
    @RequestMapping("/getCustomers")
    @ResponseBody
    public List<Customer> getCustomers() {
        return orderServer.getCustomers();
    }
    /*获取用户列表*/
    @RequestMapping("/getUsers")
    @ResponseBody
    public List<User> getUsers() {
        return orderServer.getUsers();
    }
    /*获取商品列表*/
    @RequestMapping("/getProducts")
    @ResponseBody
    public List<Product> getProducts() {
        return orderServer.getProducts();
    }
    /*添加预约信息*/
    @RequestMapping("/addOrder")
    @ResponseBody
    public String addOrder( Integer order_number, Integer order_customerid, Integer order_userid, Integer order_productid, Timestamp order_date, String order_text) {
        Order order =new Order();
        order.setOrder_customerid(5);
        order.setOrder_number(202006054);
        order.setOrder_userid(100004);
        order.setOrder_productid(3);
        Date time=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String sDate=sdf.format(time);
       order.setOrder_date(sDate);
        order.setOrder_text("成功了！");
        System.out.println("============================================================================");
        System.out.println(sDate);
        System.out.println(order);
        System.out.println("============================================================================");
       int num= orderServer.addOrder(order.getOrder_number(),order.getOrder_customerid(),order.getOrder_userid(),order.getOrder_productid(),order.getOrder_date(),order.getOrder_text());
      if(num==1)
          return "成功了";
      else
          return "失败了";
    }
    /*查询客户预约列表（按照客户id，员工id，时间，预约号）
     * 模糊查询
     * */
@RequestMapping("/getOrderByciduid")
@ResponseBody
    public List<Order> getOrderByciduid(@Param("order_customerid") Integer order_customerid, @Param("order_userid") Integer order_userid,
                                        @Param("order_date")Date order_date, @Param("order_number")Integer order_number,
                                        @Param(value="from")Integer currentPageNo,
                                        @Param(value="pageSize")Integer pageSize) {
    currentPageNo=2;pageSize=2;
        return orderServer.getOrderByciduid(order_customerid,order_userid,order_date,order_number,currentPageNo,pageSize);
    }
    /*修改（按照预约id进行修改备注和预约时间）*/
    @RequestMapping("/updaetOrder")
    @ResponseBody
    public String updateOrderByorder_id(Order order) {
    order.setOrder_id(9);
    order.setOrder_productid(3);
    order.setOrder_userid(100004);
    order.setOrder_date("2020-03-05 00:00:00");
    order.setOrder_number(202003051);
    order.setOrder_customerid(5);
    order.setOrder_text("优秀1");
        System.out.println("===================================================================");
        System.out.println(order);
        System.out.println("===================================================================");
        int i= orderServer.updateOrderByorderid(order) ;
        if(i==1){
            return "成功";
        }else
            return "失败";
    }
    /*删除（根据预约id删除）*/
    @RequestMapping("/deleteOrderByorderid")
    @ResponseBody
    public String deleteOrderByorderid(Integer order_id) {
        int i= orderServer.deleteOrderByorderid(order_id);
        if(i==1){
            return "成功";
        }else
            return "失败";
    }

    /*获取客户预约数据总数
     * 用于分页判断总数和页数
     * */
    @RequestMapping("/selectorderall")
    @ResponseBody
    public int selectorderall() {
        return orderServer.selectorderall();
    }

}
