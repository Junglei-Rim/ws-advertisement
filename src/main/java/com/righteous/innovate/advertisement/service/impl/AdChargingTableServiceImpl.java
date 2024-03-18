package com.righteous.innovate.advertisement.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.righteous.innovate.common.utils.PageUtils;
import com.righteous.innovate.common.utils.Query;

import com.righteous.innovate.advertisement.dao.AdChargingTableDao;
import com.righteous.innovate.advertisement.entity.AdChargingTableEntity;
import com.righteous.innovate.advertisement.service.AdChargingTableService;


@Service("adChargingTableService")
public class AdChargingTableServiceImpl extends ServiceImpl<AdChargingTableDao, AdChargingTableEntity> implements AdChargingTableService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AdChargingTableEntity> page = this.page(
                new Query<AdChargingTableEntity>().getPage(params),
                new QueryWrapper<AdChargingTableEntity>()
        );

        return new PageUtils(page);
    }

}