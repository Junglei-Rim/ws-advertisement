package com.righteous.innovate.advertisement.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.righteous.innovate.advertisement.entity.AdChargingTableEntity;
import com.righteous.innovate.advertisement.service.AdChargingTableService;
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
@RequestMapping("advertisement/adchargingtable")
public class AdChargingTableController {
    @Autowired
    private AdChargingTableService adChargingTableService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("advertisement:adchargingtable:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = adChargingTableService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{recordId}")
    //@RequiresPermissions("advertisement:adchargingtable:info")
    public R info(@PathVariable("recordId") Integer recordId){
		AdChargingTableEntity adChargingTable = adChargingTableService.getById(recordId);

        return R.ok().put("adChargingTable", adChargingTable);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("advertisement:adchargingtable:save")
    public R save(@RequestBody AdChargingTableEntity adChargingTable){
		adChargingTableService.save(adChargingTable);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("advertisement:adchargingtable:update")
    public R update(@RequestBody AdChargingTableEntity adChargingTable){
		adChargingTableService.updateById(adChargingTable);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("advertisement:adchargingtable:delete")
    public R delete(@RequestBody Integer[] recordIds){
		adChargingTableService.removeByIds(Arrays.asList(recordIds));

        return R.ok();
    }

}
