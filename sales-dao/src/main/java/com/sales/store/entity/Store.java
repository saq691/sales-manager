package com.sales.store.entity;

import com.sales.common.model.BaseDomail;

/**
 * 
 * 
 * @copyright: Copyright (c) 2018年1月18日 上午11:49:56
 * @author: sunaiqiang saq691@126.com
 * @version: 1.0
 */
public class Store extends BaseDomail {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2234402771225460549L;

	/**
	 * 
	 */
	private Integer id;

	/**
	 * 
	 */
	private String storeName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName == null ? null : storeName.trim();
	}

}