package com.righteous.innovate.advertisement.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author gzl
 * @email 
 * @date 2024-03-04 15:50:00
 */
@Data
@TableName("ad_charging_table")
public class AdChargingTableEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 记录ID
	 */
	@TableId
	private Integer recordId;
	/**
	 * 商家ID
	 */
	private Integer merchantId;
	/**
	 * 广告ID
	 */
	private Integer adId;
	/**
	 * 推送次数
	 */
	private Integer impressions;
	/**
	 * 点击次数
	 */
	private Integer clicks;
	/**
	 * 单价（每次推送）
	 */
	private BigDecimal pricePerImpression;
	/**
	 * 总费用
	 */
	private BigDecimal totalCost;
	/**
	 * 付款状态
	 */
	private String paymentStatus;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 创建者用户ID
	 */
	private Integer createdUser;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 更新者用户ID
	 */
	private Integer updatedUser;
	/**
	 * 是否删除（1是，0否）
	 */
	private Integer isDelete;

}
