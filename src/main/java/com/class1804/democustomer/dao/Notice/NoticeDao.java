package com.class1804.democustomer.dao.Notice;

import com.class1804.democustomer.pojo.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*公告栏*/
public interface NoticeDao {
    /*新增公告栏(员工是必须在数据库中存在的）*/
    int addnotice(@Param("notice_name") String notice_name,@Param("notice_text") String notice_text,
                  @Param("notice_userid") Integer notice_userid,@Param("notice_type") Integer notice_type,
                    @Param("notice_time") String notice_time);


/*获取公告栏数据，按照时间排序，实现分页查询（动态查询按照公告类别）*/
    List<Notice> selectnotice(@Param("notice_type") Integer notice_type, @Param(value="from")Integer currentPageNo,
                              @Param(value="pageSize")Integer pageSize);

    /*删除公告栏数据，按照公告栏id*/
    int deletenotice(@Param("notice_id") Integer notice_id);

    /*获取公告栏数据总数
    * 用于分页判断总数和页数
    * */
    int selectnoticeall();


}
