package com.class1804.democustomer.Controller.Clue;

import com.class1804.democustomer.Service.Clue.ClueService;
import com.class1804.democustomer.Service.ClueUpdate.ClueUpdateService;
import com.class1804.democustomer.Service.Customer.customerService;
import com.class1804.democustomer.Service.Product.ProductService;
import com.class1804.democustomer.Service.UserService.UserService;
import com.class1804.democustomer.dao.ClueUpdate.ClueUpdateDao;
import com.class1804.democustomer.pojo.*;
import com.class1804.democustomer.tools.PageSupport;
import com.class1804.democustomer.tools.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public String clueList(Integer clue_id, Integer clue_userid, Integer clue_custome, Integer clue_product, Integer user_jurisdiction,
                           Model model, HttpSession session,
                           String currentno,
                           String pagesize){
        //实例化分页工具类
        PageUtil pu =new PageUtil();
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


        //需要知道总共分几页
        //能根据条件查询出总记录数
        try{
          totalCount =clueService.getClueCountByParams(clue_id,clue_userid,user_jurisdiction,clue_product,clue_custome);
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
        //获取线索列表
       List<Clue> clueList =clueService.getClueListByParams(clue_id,clue_userid,clue_custome,clue_product,user_jurisdiction,curr,pageSize);

        for(int i=0;i<clueList.size();i++){
            //获取时间
            String d=clueList.get(i).getClue_date();
           // 进行截取去掉.0
            String date=d.substring(0,19);
            clueList.get(i).setClue_date(date);
            String cldate=clueList.get(i).getClueupdate_date();
            if (cldate!=null) {
                clueList.get(i).setClueupdate_date(cldate.substring(0, 19));
            }
        }
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
        session.setAttribute("cluepages",pages);
        model.addAttribute("clue_id",clue_id);
        model.addAttribute("clue_userid",clue_userid);
        model.addAttribute("clue_custome",clue_custome);
        model.addAttribute("clue_product",clue_product);

        System.out.println(pu.getTotalPageCount());

        return "/function/getClue";

    }

    //跳转线索列表页
    @RequestMapping("/toClueList")
    public String toClueList(){
        return "/function/getClue";
    }


    /*ajax获取线索列表*/
    //获取线索表内容
    @RequestMapping("/getCluelist")
    public String clueListone(Integer clue_id, Integer clue_userid, Integer clue_custome, Integer clue_product, Integer user_jurisdiction,
                                  Model model,HttpSession session,
                                  Integer currentno,
                                  Integer pagesize){
        System.out.println("clue_custome======="+clue_custome);
        if (user_jurisdiction>100){
            clue_userid=user_jurisdiction;
            user_jurisdiction=null;
        }
        //实例化分页工具类
        PageUtil pu =new PageUtil();
        PageSupport pages = new PageSupport();
        //当前页码
        Integer currentPageNo = 1;

        if(currentno != null){
            try{
                currentPageNo =currentno;
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
                pageSize = pagesize;
            }catch (NumberFormatException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        pages.setPageSize(pageSize);
        //总数量
        int totalCount=0;


        //需要知道总共分几页
        //能根据条件查询出总记录数
        try{
            totalCount =clueService.getClueCountByParams(clue_id,clue_userid,user_jurisdiction,clue_product,clue_custome);
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
        //获取线索列表
        List<Clue> clueList =clueService.getClueListByParams(clue_id,clue_userid,clue_custome,clue_product,user_jurisdiction,curr,pageSize);

        for(int i=0;i<clueList.size();i++){
            //获取时间
            String d=clueList.get(i).getClue_date();
            // 进行截取去掉.0
            String date=d.substring(0,19);
            clueList.get(i).setClue_date(date);
            String cldate=clueList.get(i).getClueupdate_date();
            if (cldate!=null) {
                clueList.get(i).setClueupdate_date(cldate.substring(0, 19));
            }
        }
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
        session.setAttribute("cluepages",pages);
        model.addAttribute("clue_id",clue_id);
        model.addAttribute("clue_userid",clue_userid);
        model.addAttribute("clue_custome",clue_custome);
        model.addAttribute("clue_product",clue_product);
        System.out.println(clueList);
        System.out.println(pages.getCurrentPageNo());
        System.out.println(pages.getTotalCount());
        System.out.println(pages.getPageSize());
        System.out.println(pages.getTotalPageCount());
        return "/function/getClue::table";
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
    @RequestMapping(value="/deleteClue/{clue_id}", produces={"application/json;charset=UTF-8"})
    @ResponseBody
    public String deleteClue(@PathVariable("clue_id") Integer clue_id) {
        Map<String, Object> result = new HashMap<>();
        Integer clueupdate_clueid = clue_id;
        int nu = clueUpdateService.databaseClueUPdate(clueupdate_clueid);
        if (nu >= 1) {
            int num = clueService.databaseClue(clue_id);
            if (num >= 1) {
                result.put("msg", "删除线索成功！");
            } else {
                result.put("msg", "删除线索失败！");
            }
        }else {
            int nums=clueService.databaseClue(clue_id);
            if (nums==1){
                result.put("msg", "删除线索成功！");
            }else {
                result.put("msg", "删除线索失败！");
            }
        }
        String jsonResult = JSON.toJSONString(result) ;
        return jsonResult;

    }



    //根据id直接响应信息(查询显示列表)
    @RequestMapping(value="/showClueList")
    @ResponseBody
    public String showClueList() {

        PageUtil pu = new PageUtil() ;
        pu.setCurrentPage(1);
        pu.setPageSize(10);

        List<Clue> clueList =clueService.getClueListByParams(0,0,0,0,0,1,5) ;

        String jsonStr = JSON.toJSONString(clueList) ;

        return jsonStr ;
    }

    //根据id直接响应信息(查看显示信息)
    @RequestMapping(value="/showClueInfo/{clue_id}")
    @ResponseBody
    public ClueClueupdateinfo showClueInfo(@PathVariable("clue_id") Integer clue_id) {
        ClueClueupdateinfo clueUpdate=clueUpdateService.getClueInfoById(clue_id);
        return clueUpdate ;
    }





}
