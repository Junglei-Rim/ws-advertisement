package com.righteous.innovate.advertisement.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.righteous.innovate.advertisement.entity.AdvertisementsEntity;
import com.righteous.innovate.advertisement.service.AdvertisementsService;
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
@RequestMapping("advertisement/advertisements")
public class AdvertisementsController {
    @Autowired
    private AdvertisementsService advertisementsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("advertisement:advertisements:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = advertisementsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{adId}")
    //@RequiresPermissions("advertisement:advertisements:info")
    public R info(@PathVariable("adId") Integer adId){
		AdvertisementsEntity advertisements = advertisementsService.getById(adId);

        return R.ok().put("advertisements", advertisements);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("advertisement:advertisements:save")
    public R save(@RequestBody AdvertisementsEntity advertisements){
		advertisementsService.save(advertisements);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("advertisement:advertisements:update")
    public R update(@RequestBody AdvertisementsEntity advertisements){
		advertisementsService.updateById(advertisements);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("advertisement:advertisements:delete")
    public R delete(@RequestBody Integer[] adIds){
		advertisementsService.removeByIds(Arrays.asList(adIds));

        return R.ok();
    }

}
