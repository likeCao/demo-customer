package com.class1804.democustomer.Controller.Clue;

import com.class1804.democustomer.Service.Clue.ClueService;
import com.class1804.democustomer.Service.ClueUpdate.ClueUpdateService;
import com.class1804.democustomer.Service.Customer.customerService;
import com.class1804.democustomer.Service.Product.ProductService;
import com.class1804.democustomer.Service.UserService.UserService;
import com.class1804.democustomer.dao.ClueUpdate.ClueUpdateDao;
import com.class1804.democustomer.pojo.*;
import com.class1804.democustomer.tools.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 获取线索内容
 * 删除线索数据
 * 添加线索数据
 * 新增更新线索
 * 查询线索数据
 * 查看线索信息
 */
@Controller
@RequestMapping("/Clue")
public class ClueController {
    //线索
    @Autowired
    private ClueService clueService;
    //客户
   @Autowired
   private customerService customerService;
    //员工
    @Autowired
   private UserService userService;
    //商品
    @Autowired
    private ProductService productService;
    //更新线索
    @Autowired
    private ClueUpdateService clueUpdateService;

   //获取线索表内容
    @RequestMapping("/getClue")
    public String clueList(Integer clue_id,Integer clue_userid,Integer clue_custome,Integer clue_product,
                           Model model,
                           Integer currentPageNo,
                           Integer pageSize){

        //给PageUtil赋值当前页码和一页显示多少条
        PageUtil pu = new PageUtil() ;

        //当前页码
        if(currentPageNo == null) {
            pu.setCurrentPage(1);
        }
        else {
            pu.setCurrentPage(currentPageNo);
        }

        //一页显示条数
        if(pageSize == null) {
            pu.setPageSize(10);
        }
        else {
            pu.setPageSize(pageSize);
        }

        //获取线索列表
       List<Clue> clueList =clueService.getClueListByParams(clue_userid,clue_custome,clue_product,pu);

        //将结果存入PageUtil里
        pu.setList(clueList);

        //获取员工列表
        List<User> userList = userService.getUserList();


        //获取客户列表
        List<Customer> customerList=customerService.getCustomer();

        //获取商品列表
        List<Product> productList=productService.getProduct();

        model.addAttribute("pu",pu);
        model.addAttribute("userList",userList);
        model.addAttribute("customerList",customerList);
        model.addAttribute("productList",productList);

        model.addAttribute("clue_id",clue_id);
        model.addAttribute("clue_userid",clue_userid);
        model.addAttribute("clue_custome",clue_custome);
        model.addAttribute("clue_product",clue_product);


        /**
         *          request.setAttribute("pu",pu);
         *          request.setAttribute("userList",userList);
         *         request.setAttribute("customerList",customerList);
         *         request.setAttribute("productList",productList);
         *
         *         request.setAttribute("clue_id",clue_id);
         *         request.setAttribute("clue_userid",clue_userid);
         *         request.setAttribute("clue_custome",clue_custome);
         *         request.setAttribute("clue_product",clue_product);
         */


        return "/function/getClue";

    }

    //跳转线索列表页
    @RequestMapping("/toClueList")
    public String toClueList(){
        return "/function/getClue";
    }

    //跳转到添加线索页面
    @RequestMapping("/toAddClue")
    public String toAddClue(Model model){
        //获取员工列表
        List<User> userList = userService.getUserList();

        //获取客户列表
        List<Customer> customerList=customerService.getCustomer();

        //获取商品列表
        List<Product> productList=productService.getProduct();

        model.addAttribute("userList",userList);
        model.addAttribute("customerList",customerList);
        model.addAttribute("productList",productList);

        return "/function/addClue";
    }

    //跳转到新增线索页面
    @RequestMapping("/toAddNewClue")
    public String toAddNewClue(Model model){
        //获取员工列表
        List<User> userList = userService.getUserList();

        //获取线索列表
        List<Clue> clueList =clueService.getClue();

        model.addAttribute("userList",userList);
        model.addAttribute("clueList",clueList);

        return "/function/newClue";
    }


    //添加线索
    @RequestMapping("/addClue")
    public String addClue( Clue clue,Model model){
        String msg="";
        int num=clueService.setClue(clue);
        if (num == 1){
            msg="添加线索成功！";
        }else{
            msg="添加线索失败！";
        }
        model.addAttribute("msg",msg);
        return "/function/addClue";
    }

    //新增线索
    @RequestMapping("/newClue")
    public String newClue(ClueUpdate clueUpdate, Model model){
        String msg="";
        int num=clueUpdateService.seClueUpdate(clueUpdate);
        if (num == 1){
            msg="添加线索成功！";
        }else{
            msg="添加线索失败！";
        }
        model.addAttribute("msg",msg);
        return "/function/newClue";
    }

    //删除线索
    @RequestMapping(value="/deleteClue", produces={"application/json;charset=UTF-8"})
    @ResponseBody
    public String deleteClue(int clue_id,int clueupdate_clueid){
        Map<String, Object> result = new HashMap<>() ;
        int num=clueUpdateService.databaseClueUPdate(clueService.databaseClue(clue_id));
        if (num >= 1){
            result.put("msg","删除线索成功！");
        }else{
            result.put("msg","删除线索失败！");
        }
        String jsonResult = JSON.toJSONString(result) ;
        return "jsonResult";

    }



    //根据id直接响应信息(查询显示列表)
    @RequestMapping(value="/showClueList")
    @ResponseBody
    public String showClueList() {

        PageUtil pu = new PageUtil() ;
        pu.setCurrentPage(1);
        pu.setPageSize(10);

        List<Clue> clueList =clueService.getClueListByParams(0,0,0,pu) ;

        String jsonStr = JSON.toJSONString(clueList) ;

        return jsonStr ;
    }

    //根据id直接响应信息(查看显示信息)
    @RequestMapping(value="/showClueInfo")
    @ResponseBody
    public ClueUpdate showClueInfo(int clue_id) {
        ClueUpdate clueUpdate=clueUpdateService.getClueInfoById(clue_id);

        return clueUpdate ;
    }





}
