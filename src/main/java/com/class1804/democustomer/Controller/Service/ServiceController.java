package com.class1804.democustomer.Controller.Service;

import com.class1804.democustomer.Service.Service.ServiceService;
import com.class1804.democustomer.pojo.Service;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.List;

/*客户售后表
 *这个Controller是测试！！！！！！！！！！！！！
 * 这个Controller是测试！！！！！！！！！
 * 测试添加售后数据成功
 * 测试查询客户售后成功
* */
@Controller
@RequestMapping("/Service")
public class ServiceController {
    @Resource
    private ServiceService serviceService;

    /*新增客户售后数据（客户、员工、产品必须是数据库中存在的）
     * 与客户预约添加类似，所需客户、员工、产品的信息方法预约表已实现
     * */
    @RequestMapping("/addService")
    @ResponseBody
    public String addService(String service_content, String service_date, Integer service_userid, Integer service_Situation, Integer service_productid, Integer service_customerid) {
        Service service=new Service();
        service.setService_content("666666");
        service.setService_date("2020-05-06 10:00:00");
        service.setService_userid(100004);
        service.setService_Situation(3);
        service.setService_productid(3);
        service.setService_customerid(6);
        System.out.println("==================================================================");
        System.out.println(service);
        System.out.println("==================================================================");
        int i= serviceService.addService(service.getService_content(),service.getService_date(),service.getService_userid(),service.getService_Situation(),service.getService_productid(),service.getService_customerid());
        if(i==1){
            return "成功";
        }else
            return "失败";
    }

    /*查询客户售后（动态查询按照客户姓名、员工id、售后评价、产品id）
     * 页面显示客户名，获取数据为客户id，类型搜索框
     * */
    @RequestMapping("/selectService")
    @ResponseBody
    public List<Service> selectService(String customer_name, Integer user_id, Integer service_situation, Integer product_id,
                                       @Param(value="from")Integer currentPageNo,
                                       @Param(value="pageSize")Integer pageSize) {
        Service service=new Service();
        customer_name="li";
        user_id=100004;
        product_id=3;
        service_situation=3;
        currentPageNo=2;pageSize=2;
        return serviceService.selectService(customer_name,user_id,service_situation,product_id,currentPageNo,pageSize);
        }

    }

