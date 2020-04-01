package com.class1804.democustomer.Controller.Customer;

import com.class1804.democustomer.Service.Customer.customerService;
import com.class1804.democustomer.Service.OrderService.OrderServer;
import com.class1804.democustomer.pojo.ClueCustomerUser;
import com.class1804.democustomer.pojo.Customer;
import com.class1804.democustomer.pojo.User;
import com.class1804.democustomer.tools.PageSupport;
import org.apache.catalina.Session;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public  String selectClueCusUser(HttpServletRequest request,HttpSession session,Integer customer_id, Integer user_id, Integer user_jurisdiction, String clue_date, String user_name,
                                    Integer customer_gender,String customer_name,
                                    @Param(value="from")String currentno,
                                    @Param(value="pageSize")String pagesize) {

        Integer userid=null;
        if (user_id!=null){
            userid=user_id;
        }

        //实例化分页工具类
       PageSupport pages = new PageSupport();
        //当前页码
        Integer currentPageNo = 1;

        if(currentno != null){
            try{
                currentPageNo = Integer.valueOf(currentno);
            }catch (NumberFormatException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            pages.setCurrentPageNo(currentPageNo);
        }
        //页面容量
        Integer pageSize=5;
        if(pagesize!=null)
        try{
            pageSize = Integer.valueOf(pagesize);
        }catch (NumberFormatException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
            pages.setPageSize(pageSize);
        //总数量
        int totalCount=0;
        try {
            totalCount = customerService.selectClueCusUserCount(customer_id,user_id,user_jurisdiction,user_name,customer_gender,customer_name);

        }catch (Exception e){
            e.printStackTrace();
        }
        pages.setTotalCount(totalCount);
        //总页数
        int totalPageCount = pages.getTotalPageCount();
        //控制首页和尾页
        if(currentPageNo < 1){
            currentPageNo = 1;
        }else if(currentPageNo > totalPageCount){
            currentPageNo = totalPageCount;
        }

        //控制传入当前页的值
        Integer curr=(currentPageNo-1)*pageSize;
        List<ClueCustomerUser> customerList= customerService.selectClueCusUser(customer_id,user_id,user_jurisdiction,user_name,customer_gender,customer_name,curr,pageSize);

        for(int i=0;i<customerList.size();i++) {
            if (customerList.get(i).getCustomer_text() == null||customerList.get(i).getCustomer_text()=="") {
                customerList.get(i).setCustomer_text("暂无备注");
            }
        }
        request.setAttribute("customers",customerList);
        session.setAttribute("page",pages);
      return "forward:/Customer/toCustomerList";
    }

    @RequestMapping("/getCustomerListone")
    public String selectlist(HttpServletRequest request,HttpSession session,Integer customer_id, Integer user_id, Integer user_jurisdiction, String clue_date, String user_name,
                             Integer customer_gender,String customer_name,
                             @Param(value="from")String currentno,
                             @Param(value="pageSize")String pagesize) {

        if (user_jurisdiction>100){
            user_id=user_jurisdiction;
            user_jurisdiction=null;
        }
        //实例化分页工具类
        PageSupport pages = new PageSupport();
        //当前页码
        Integer currentPageNo = 1;

        if(currentno != null){
            try{
                currentPageNo = Integer.valueOf(currentno);
            }catch (NumberFormatException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            pages.setCurrentPageNo(currentPageNo);
        }
        //页面容量
        Integer pageSize=5;
        if(pagesize!=null)
            try{
                pageSize = Integer.valueOf(pagesize);
            }catch (NumberFormatException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        pages.setPageSize(pageSize);
        //总数量
        int totalCount=0;
        try {
            totalCount = customerService.selectClueCusUserCount(customer_id,user_id,user_jurisdiction,user_name,customer_gender,customer_name);
        }catch (Exception e){
            e.printStackTrace();
        }
        pages.setTotalCount(totalCount);
        //总页数
        int totalPageCount = pages.getTotalPageCount();
        //控制首页和尾页
        if(currentPageNo < 1){
            currentPageNo = 1;
        }else if(currentPageNo > totalPageCount){
            currentPageNo = totalPageCount;
        }
        //控制传入当前页的值
        Integer curr=(currentPageNo-1)*pageSize;
        List<ClueCustomerUser> customerList= customerService.selectClueCusUser(customer_id,user_id,user_jurisdiction,user_name,customer_gender,customer_name,curr,pageSize);

        for(int i=0;i<customerList.size();i++) {
            if (customerList.get(i).getCustomer_text() == null||customerList.get(i).getCustomer_text()=="") {
                customerList.get(i).setCustomer_text("暂无备注");
            }
        }
        request.setAttribute("customers",customerList);
        session.setAttribute("page",pages);
        return "/function/CustomerList ::tablelist";
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
        customer.setCustomer_address(customer_address);
            customer.setCustomer_birthday(customer_birthday);
            customer.setCustomer_gender(customer_gender);
            customer.setCustomer_jurisdiction(customer_jurisdiction);
            customer.setCustomer_money(customer_money);
            customer.setCustomer_name(customer_name);
            customer.setCustomer_number(customer_number);
            customer.setCustomer_text(customer_text);
            customer.setCustomer_userid(user_id);
            int i = customerService.setCustomer(customer);
            if (i == 1) {
                msg = "添加成功";
            } else {
                msg = "添加失败";
            }
            request.setAttribute("msg", msg);
            return "redirect:/Customer/getCustomerList";

        }


        /*根据修改客户的id，修改到的等级去进行客户的等级修改*/
    @RequestMapping("/updateCustomerJ/{customer_id}")
    @ResponseBody
    public String updateCustomerJ(@PathVariable("customer_id") Integer customer_id, Integer customer_jurisdiction) {
        int i= customerService.updateCustomerJ(customer_id,customer_jurisdiction);
        if(i==1){
            return "修改成功";
        }else
            return "修改失败";
    }

/*跳转修改客户页面*/
    @RequestMapping("/toupdateCustomer/{customer_id}")
    public String toupdateCustomer(@PathVariable("customer_id") Integer customer_id,Model model){
        System.out.println(customer_id);
        Customer customer =customerService.selectCustomerByid(customer_id);
        String cJurisdiction=null;
        if (customer!=null){
            if (customer.getCustomer_jurisdiction()==4){
                cJurisdiction="普通客户";
            }else if (customer.getCustomer_jurisdiction()==5){
                cJurisdiction="白银客户";
            }else if (customer.getCustomer_jurisdiction()==6) {
                cJurisdiction = "黄金客户";
            } else if (customer.getCustomer_jurisdiction()==7) {
                    cJurisdiction = "钻石客户";
                }
            model.addAttribute("customer",customer);
            model.addAttribute("cJurisdiction",cJurisdiction);
        }
        return "/function/updaCustomer";
    }


    /*根据客户id修改客户的信息*/
    @RequestMapping("/updateCustomer")
    public String updateCustomer(Customer customer,HttpServletRequest request) {

        int i= customerService.updateCustomer(customer);
        if (i==1){
            request.setAttribute("msg","修改成功");
        }else {
            request.setAttribute("msg", "修改失败");
            return "/function/updaCustomer";
        }
        return "redirect:/Customer/getCustomerList";
    }


}
