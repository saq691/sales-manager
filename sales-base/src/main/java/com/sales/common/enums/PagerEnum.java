package com.sales.common.enums;

/**
 * 分页默认值枚举类
 * 
 * @copyright: Copyright (c) 2018年1月18日 上午11:05:52
 * @author: sunaiqiang saq691@126.com
 * @version: 1.0
 */
public enum PagerEnum {

	/**
	 * 当前页
	 */
	PAGE(1),
	/**
	 * 每页大小值1
	 */
	LIMIT_1(1),
	/**
	 * 每页大小值3
	 */
	LIMIT_3(3),
	/**
	 * 每页大小值4
	 */
	LIMIT_4(4),
	/**
	 * 每页大小值5
	 */
	LIMIT_5(5),
	/**
	 * 每页大小值10
	 */
	LIMIT_10(10),
	/**
	 * 每页大小值12
	 */
	LIMIT_12(12),
	/**
	 * 每页大小值16
	 */
	LIMIT_16(16),
	/**
	 * 每页大小值20
	 */
	LIMIT_20(20),
	/**
	 * 每页大小值30
	 */
	LIMIT_30(30);

	private int value;

	private PagerEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
