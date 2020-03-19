package com.class1804.democustomer.Service.MarketingService;

import com.class1804.democustomer.pojo.Marketing;

import java.util.List;

public interface MarketingService {

    //新增营销
    int marketingAdd(Marketing marketing);

    //查询营销列表 按照时间排序（负责人、产品）
    List<Marketing> getMarketings(Marketing marketing);

    //修改营销列表，按照营销id
    int updateMarketingByMarketing_id(Marketing marketing);
}
