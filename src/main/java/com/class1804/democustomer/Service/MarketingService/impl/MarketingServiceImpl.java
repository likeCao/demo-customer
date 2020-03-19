package com.class1804.democustomer.Service.MarketingService.impl;

import com.class1804.democustomer.dao.MarketingDao.MarketingDao;
import com.class1804.democustomer.pojo.Marketing;
import com.class1804.democustomer.Service.MarketingService.MarketingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketingServiceImpl implements MarketingService {

    @Autowired
    private MarketingDao marketingDao;


    //新增营销
    @Override
    public int marketingAdd(Marketing marketing) {
        return marketingDao.marketingAdd(marketing);
    }

    //查询营销列表，按照时间排序（负责人、产品）
    @Override
    public List<Marketing> getMarketings(Marketing marketing) {
        return marketingDao.getMarketings(marketing);
    }

    //修改营销列表，按照营销id
    @Override
    public int updateMarketingByMarketing_id(Marketing marketing) {
        return marketingDao.updateMarketingByMarketing_id(marketing);
    }




}
