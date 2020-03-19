package com.class1804.democustomer.Service.NoticeService.Impl;

import com.class1804.democustomer.Service.NoticeService.NoticeService;
import com.class1804.democustomer.dao.Notice.NoticeDao;
import com.class1804.democustomer.pojo.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeDao noticeDao;

    /*新增公告栏(员工是必须在数据库中存在的）*/
    @Override
    public int addnotice(String notice_name, String notice_text, Integer notice_userid, Integer notice_type,String notice_time) {
        return noticeDao.addnotice(notice_name,notice_text,notice_userid,notice_type,notice_time);
    }

    /*获取公告栏数据，按照时间排序，实现分页查询（动态查询按照公告类别）*/
    @Override
    public List<Notice> selectnotice(Integer notice_type, Integer currentPageNo, Integer pageSize) {
        return noticeDao.selectnotice(notice_type,currentPageNo,pageSize);
    }


    /*删除公告栏数据，按照公告栏id*/
    @Override
    public int deletenotice(Integer notice_id) {
        return noticeDao.deletenotice(notice_id);
    }



    /*获取公告栏数据总数
     * 用于分页判断总数和页数
     * */
    @Override
    public int selectnoticeall() {
        return noticeDao.selectnoticeall();
    }


}
