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
@TableName("advertisements")
public class AdvertisementsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 广告ID
	 */
	@TableId
	private Integer adId;
	/**
	 * 商家ID
	 */
	private Integer merchantId;
	/**
	 * 广告内容
	 */
	private String content;
	/**
	 * 广告类型
	 */
	private String type;
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
