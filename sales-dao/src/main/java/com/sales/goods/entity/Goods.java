package com.sales.goods.entity;

import com.sales.common.model.BaseDomail;

/**
 * 
 * 
 * @copyright: Copyright (c) 2018年1月18日 上午11:47:27
 * @author: sunaiqiang saq691@126.com
 * @version: 1.0
 */
public class Goods extends BaseDomail {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6828391105753710151L;

	/**
	 * 
	 */
	private Integer id;

	/**
	 * 
	 */
	private String goodsSku;

	/**
	 * 
	 */
	private String goodsName;

	/**
	 * 
	 */
	private Integer goodsNum;

	/**
	 * 
	 */
	private Integer version;

	/**
	 * 
	 */
	private Integer storeId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGoodsSku() {
		return goodsSku;
	}

	public void setGoodsSku(String goodsSku) {
		this.goodsSku = goodsSku == null ? null : goodsSku.trim();
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName == null ? null : goodsName.trim();
	}

	public Integer getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

}