package com.class1804.democustomer.Controller.Notice;

import com.class1804.democustomer.Service.NoticeService.NoticeService;
import com.class1804.democustomer.pojo.Notice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.List;

/*公告栏表
*这个Controller是测试！！！！！！！！！！！！！
* 这个Controller是测试！！！！！！！！！
* 测试添加公告数据成功
* */
@Controller
@RequestMapping("/Notice")
public class NoticeController {
    @Resource
    private NoticeService noticeService;

    /*新增公告栏(员工是必须在数据库中存在的）*/
    @RequestMapping("/addnotice")
    @ResponseBody
    public String addnotice(String notice_name, String notice_text, Integer notice_userid, Integer notice_type,String notice_time) {
       notice_name="这是公告栏的介绍2";
       notice_text="这是公告栏的内容2";
       notice_userid=100004;
       notice_type=3;
       notice_time="2020-02-09 12:00:00";
        int num = noticeService.addnotice(notice_name,notice_text,notice_userid,notice_type,notice_time);
        if(num==1)
            return "成功了";
        else
            return "失败了";


    }
    /*获取公告栏数据，按照时间排序，实现分页查询（动态查询按照公告类别）*/
    @RequestMapping("/selectnotice")
    @ResponseBody
    public List<Notice> selectnotice(Integer notice_type, Integer currentPageNo, Integer pageSize) {
   /* currentPageNo=0;pageSize=2;
    notice_type=3;*/
        return noticeService.selectnotice(notice_type,currentPageNo,pageSize);
    }

    /*删除公告栏数据，按照公告栏id*/
    @RequestMapping("/deletenotice")
    @ResponseBody
    public String deletenotice(Integer notice_id) {
        notice_id=7;
        int num = noticeService.deletenotice(notice_id);
        if(num==1)
            return "成功了";
        else
            return "失败了";
    }



    /*获取公告栏数据总数
     * 用于分页判断总数和页数
     * */
    @RequestMapping("/selectnoticeall")
    @ResponseBody
    public int selectnoticeall() {
        return noticeService.selectnoticeall();
    }
}
