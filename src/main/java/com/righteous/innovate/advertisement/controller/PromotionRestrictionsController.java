package com.righteous.innovate.advertisement.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.righteous.innovate.advertisement.entity.PromotionRestrictionsEntity;
import com.righteous.innovate.advertisement.service.PromotionRestrictionsService;
import com.righteous.innovate.common.utils.PageUtils;
import com.righteous.innovate.common.utils.R;



/**
 * 
 *
 * @author gzl
 * @email 
 * @date 2024-03-04 15:50:00
 */
@RestController
@RequestMapping("advertisement/promotionrestrictions")
public class PromotionRestrictionsController {
    @Autowired
    private PromotionRestrictionsService promotionRestrictionsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("advertisement:promotionrestrictions:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = promotionRestrictionsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{restrictionId}")
    //@RequiresPermissions("advertisement:promotionrestrictions:info")
    public R info(@PathVariable("restrictionId") Integer restrictionId){
		PromotionRestrictionsEntity promotionRestrictions = promotionRestrictionsService.getById(restrictionId);

        return R.ok().put("promotionRestrictions", promotionRestrictions);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("advertisement:promotionrestrictions:save")
    public R save(@RequestBody PromotionRestrictionsEntity promotionRestrictions){
		promotionRestrictionsService.save(promotionRestrictions);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("advertisement:promotionrestrictions:update")
    public R update(@RequestBody PromotionRestrictionsEntity promotionRestrictions){
		promotionRestrictionsService.updateById(promotionRestrictions);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("advertisement:promotionrestrictions:delete")
    public R delete(@RequestBody Integer[] restrictionIds){
		promotionRestrictionsService.removeByIds(Arrays.asList(restrictionIds));

        return R.ok();
    }

}
