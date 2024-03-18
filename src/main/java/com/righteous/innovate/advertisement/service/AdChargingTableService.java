package com.righteous.innovate.advertisement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.righteous.innovate.common.utils.PageUtils;
import com.righteous.innovate.advertisement.entity.AdChargingTableEntity;

import java.util.Map;

/**
 * 
 *
 * @author gzl
 * @email 
 * @date 2024-03-04 15:50:00
 */
public interface AdChargingTableService extends IService<AdChargingTableEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

