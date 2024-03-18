package com.righteous.innovate.advertisement.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.righteous.innovate.advertisement.entity.MerchantsEntity;
import com.righteous.innovate.advertisement.service.MerchantsService;
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
@RequestMapping("advertisement/merchants")
public class MerchantsController {
    @Autowired
    private MerchantsService merchantsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("advertisement:merchants:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = merchantsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{merchantId}")
    //@RequiresPermissions("advertisement:merchants:info")
    public R info(@PathVariable("merchantId") Integer merchantId){
		MerchantsEntity merchants = merchantsService.getById(merchantId);

        return R.ok().put("merchants", merchants);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("advertisement:merchants:save")
    public R save(@RequestBody MerchantsEntity merchants){
		merchantsService.save(merchants);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("advertisement:merchants:update")
    public R update(@RequestBody MerchantsEntity merchants){
		merchantsService.updateById(merchants);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("advertisement:merchants:delete")
    public R delete(@RequestBody Integer[] merchantIds){
		merchantsService.removeByIds(Arrays.asList(merchantIds));

        return R.ok();
    }

}
