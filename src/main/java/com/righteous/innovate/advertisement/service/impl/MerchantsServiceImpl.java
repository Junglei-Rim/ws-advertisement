package com.righteous.innovate.advertisement.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.righteous.innovate.common.utils.PageUtils;
import com.righteous.innovate.common.utils.Query;

import com.righteous.innovate.advertisement.dao.MerchantsDao;
import com.righteous.innovate.advertisement.entity.MerchantsEntity;
import com.righteous.innovate.advertisement.service.MerchantsService;


@Service("merchantsService")
public class MerchantsServiceImpl extends ServiceImpl<MerchantsDao, MerchantsEntity> implements MerchantsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MerchantsEntity> page = this.page(
                new Query<MerchantsEntity>().getPage(params),
                new QueryWrapper<MerchantsEntity>()
        );

        return new PageUtils(page);
    }

}