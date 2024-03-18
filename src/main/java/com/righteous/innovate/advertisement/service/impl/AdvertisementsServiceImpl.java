package com.righteous.innovate.advertisement.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.righteous.innovate.common.utils.PageUtils;
import com.righteous.innovate.common.utils.Query;

import com.righteous.innovate.advertisement.dao.AdvertisementsDao;
import com.righteous.innovate.advertisement.entity.AdvertisementsEntity;
import com.righteous.innovate.advertisement.service.AdvertisementsService;


@Service("advertisementsService")
public class AdvertisementsServiceImpl extends ServiceImpl<AdvertisementsDao, AdvertisementsEntity> implements AdvertisementsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AdvertisementsEntity> page = this.page(
                new Query<AdvertisementsEntity>().getPage(params),
                new QueryWrapper<AdvertisementsEntity>()
        );

        return new PageUtils(page);
    }

}