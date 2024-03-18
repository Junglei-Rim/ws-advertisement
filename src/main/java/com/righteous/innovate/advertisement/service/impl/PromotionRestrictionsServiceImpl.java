package com.righteous.innovate.advertisement.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.righteous.innovate.common.utils.PageUtils;
import com.righteous.innovate.common.utils.Query;

import com.righteous.innovate.advertisement.dao.PromotionRestrictionsDao;
import com.righteous.innovate.advertisement.entity.PromotionRestrictionsEntity;
import com.righteous.innovate.advertisement.service.PromotionRestrictionsService;


@Service("promotionRestrictionsService")
public class PromotionRestrictionsServiceImpl extends ServiceImpl<PromotionRestrictionsDao, PromotionRestrictionsEntity> implements PromotionRestrictionsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PromotionRestrictionsEntity> page = this.page(
                new Query<PromotionRestrictionsEntity>().getPage(params),
                new QueryWrapper<PromotionRestrictionsEntity>()
        );

        return new PageUtils(page);
    }

}