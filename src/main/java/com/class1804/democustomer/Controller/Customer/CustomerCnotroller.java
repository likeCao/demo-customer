package com.class1804.democustomer.Controller.Customer;

import com.class1804.democustomer.Service.Customer.customerService;
import com.class1804.democustomer.Service.OrderService.OrderServer;
import com.class1804.democustomer.pojo.ClueCustomerUser;
import com.class1804.democustomer.pojo.Customer;
import com.class1804.democustomer.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/*
* 这是客户Controller
* 实现客户的一些业务方法
* */
@Controller
@RequestMapping("/Customer")
public class CustomerCnotroller {
    @Autowired
    private customerService customerService;
    @Autowired
    private  OrderServer orderServer;

    /*获取客户列表，默认查询全部，根据时间排序
    * 实现按当前登录用用户的级别可动态实现以下功能
    * 全部客户，我的客户，下属客户
    *按线索跟进时间查询，按负责人查询
    * 列表显示姓名，电话，跟进时间，跟进状态，备注，负责人等信息
    * */
    @RequestMapping("/getCustomerList")
    public String selectClueCusUser(HttpServletRequest request,Integer user_id, Integer user_jurisdiction, String clue_date, String user_name,
                                    @Param(value="from")Integer currentPageNo,
                                    @Param(value="pageSize")Integer pageSize) {
      /*  if (currentPageNo==null){
            currentPageNo=0;
        }
        if (pageSize==null){
            pageSize=5;
        }*/

        List<ClueCustomerUser> customerList= customerService.selectClueCusUser(user_id,user_jurisdiction,clue_date,user_name,currentPageNo,pageSize);

        for(int i=0;i<customerList.size();i++) {
            if (customerList.get(i).getCustomer_text() == null||customerList.get(i).getCustomer_text()=="") {
                customerList.get(i).setCustomer_text("暂无备注");
            }
            if (customerList.get(i).getClue_date() == null||customerList.get(i).getClue_date()=="") {
                customerList.get(i).setClue_date("0000-00-00 00:00:00");
            }
            if (customerList.get(i).getClue_state() == null||customerList.get(i).getClue_state()=="") {
                customerList.get(i).setClue_state("尚未开始");
            }
            String d = customerList.get(i).getClue_date();
            if (d != null) {
                String date = d.substring(0, 19);
                customerList.get(i).setClue_date(date);
            }
        }




        request.setAttribute("customers",customerList);
      return "forward:/Customer/toCustomerList";
    }
    /*跳转客户列表页CustomerList
    * */
    @RequestMapping("/toCustomerList")
    public String toCustomerList(){
        return "/function/CustomerList";
    }
    /*跳转客户添加页addCustomer
     * */

    @RequestMapping("/toaddCustomer")
    public String toaddCustomer(HttpServletRequest request){
        //获取员工列表信息
        List<User> userList =orderServer.getUsers();
        if(userList!=null){
            request.setAttribute("userList",userList);
        }else {
            return "失败";
        }
        return "/function/addCustomer";
    }
/*新增客户信息*/
    @PostMapping("/setCustomer")
    public String setCustomer(HttpServletRequest request) {
        String msg = null;
        String customer_name = request.getParameter("customer_name");
        Integer customer_gender = Integer.parseInt(request.getParameter("customer_gender"));
        String customer_number = request.getParameter("customer_number");
        Integer user_id=Integer.parseInt(request.getParameter("user_id"));
        Double customer_money = Double.parseDouble(request.getParameter("customer_money"));
        Integer customer_jurisdiction=Integer.parseInt(request.getParameter("customer_jurisdiction"));
        String customer_address = request.getParameter("customer_address");
        String customer_birthday = request.getParameter("customer_birthday");
        String customer_text = request.getParameter("customer_text");
        Customer customer = new Customer();
        System.out.println(customer_birthday);
        customer.setCustomer_address(customer_address);
            customer.setCustomer_birthday(customer_birthday);
            customer.setCustomer_gender(customer_gender);
            customer.setCustomer_jurisdiction(customer_jurisdiction);
            customer.setCustomer_money(customer_money);
            customer.setCustomer_name(customer_name);
            customer.setCustomer_number(customer_number);
            customer.setCustomer_text(customer_text);
            customer.setCustomer_userid(user_id);
            System.out.println("========================================================================");
            System.out.println(customer);
            int i = customerService.setCustomer(customer);
            if (i == 1) {
                msg = "添加成功";
            } else {
                msg = "添加失败";
            }
            request.setAttribute("msg", msg);
            return "redirect:/Customer/getCustomerList";

        }


}
