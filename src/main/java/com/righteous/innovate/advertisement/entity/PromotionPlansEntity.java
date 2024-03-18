package com.righteous.innovate.advertisement.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

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
@TableName("promotion_plans")
public class PromotionPlansEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 计划ID
	 */
	@TableId
	private Integer planId;
	/**
	 * 广告类型
	 */
	private String adType;
	/**
	 * 推广开始时间
	 */
	private Date startTime;
	/**
	 * 推广结束时间
	 */
	private Date endTime;
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
