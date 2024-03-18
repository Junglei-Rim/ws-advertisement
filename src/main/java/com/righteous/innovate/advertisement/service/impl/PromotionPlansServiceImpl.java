package com.righteous.innovate.advertisement.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.righteous.innovate.common.utils.PageUtils;
import com.righteous.innovate.common.utils.Query;

import com.righteous.innovate.advertisement.dao.PromotionPlansDao;
import com.righteous.innovate.advertisement.entity.PromotionPlansEntity;
import com.righteous.innovate.advertisement.service.PromotionPlansService;


@Service("promotionPlansService")
public class PromotionPlansServiceImpl extends ServiceImpl<PromotionPlansDao, PromotionPlansEntity> implements PromotionPlansService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PromotionPlansEntity> page = this.page(
                new Query<PromotionPlansEntity>().getPage(params),
                new QueryWrapper<PromotionPlansEntity>()
        );

        return new PageUtils(page);
    }

}