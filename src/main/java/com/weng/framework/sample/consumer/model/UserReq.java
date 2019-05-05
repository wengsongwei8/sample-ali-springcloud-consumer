package com.weng.framework.sample.consumer.model;

import com.weng.framework.dao.mybatis.entity.BaseEntity;
import com.weng.framework.validator.annotation.NotEmpty;
import com.weng.framework.validator.annotation.Phone;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


/**
 * 用户基础信息表请求
 *
 * @author wengzhonghui
 * @date 2019-03-11 07:18:17
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserReq extends BaseEntity<UserReq> {

	private static final long serialVersionUID = 1L;

	private String id;

	/**
     * 登录账号
     */
	@NotEmpty
	private String account;
    
	/**
     * 密码（md5）
     */
	private String pwd;
    
	/**
     * 真实姓名
     */
	private String truename;
    
	/**
     * 手机号码
     */
	@Phone
	private String mobile;
    
	/**
     * 电子邮箱
     */
	private String email;
    
	/**
     * 身份证号
     */
	private String idCard;
    

	@Override
	protected Serializable pkVal() {
		return null;
	}
}
