package com.sales.web.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 用户登录model类
 * 
 * @copyright: Copyright (c) 2018年3月9日 下午2:31:39
 * @author: sunaiqiang saq691@126.com
 * @version: 1.0
 */
public class LoginModel implements Serializable {
	private static final long serialVersionUID = 351750024159724329L;
	/**
	 * 用户名
	 */
	@NotBlank(message = "请输入登录用户名")
	private String username;
	/**
	 * 密码
	 */
	@NotBlank(message = "请输入登录密码")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}