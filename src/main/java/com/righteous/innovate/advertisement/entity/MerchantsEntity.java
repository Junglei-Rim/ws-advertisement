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
@TableName("merchants")
public class MerchantsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 商家ID
	 */
	@TableId
	private Integer merchantId;
	/**
	 * 商家名称
	 */
	private String name;
	/**
	 * 联系方式
	 */
	private String contact;
	/**
	 * 账户
	 */
	private String account;
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
