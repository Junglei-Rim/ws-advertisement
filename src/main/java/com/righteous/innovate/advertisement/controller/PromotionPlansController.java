package com.righteous.innovate.advertisement.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.righteous.innovate.advertisement.entity.PromotionPlansEntity;
import com.righteous.innovate.advertisement.service.PromotionPlansService;
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
@RequestMapping("advertisement/promotionplans")
public class PromotionPlansController {
    @Autowired
    private PromotionPlansService promotionPlansService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("advertisement:promotionplans:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = promotionPlansService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{planId}")
    //@RequiresPermissions("advertisement:promotionplans:info")
    public R info(@PathVariable("planId") Integer planId){
		PromotionPlansEntity promotionPlans = promotionPlansService.getById(planId);

        return R.ok().put("promotionPlans", promotionPlans);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("advertisement:promotionplans:save")
    public R save(@RequestBody PromotionPlansEntity promotionPlans){
		promotionPlansService.save(promotionPlans);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("advertisement:promotionplans:update")
    public R update(@RequestBody PromotionPlansEntity promotionPlans){
		promotionPlansService.updateById(promotionPlans);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("advertisement:promotionplans:delete")
    public R delete(@RequestBody Integer[] planIds){
		promotionPlansService.removeByIds(Arrays.asList(planIds));

        return R.ok();
    }

}
