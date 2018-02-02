package com.sales.common.dictionary.model;

import com.sales.common.model.BaseModel;

/**
 * 数据字典Model类
 * 
 * @copyright: Copyright (c) 2017年12月10日 下午7:16:51
 * @author: sunaiqiang saq691@126.com
 * @version: 1.0
 */
public class ResultData extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3326976180935929358L;

	/**
	 * 
	 */
	private String id;

	/**
	 * 
	 */
	private String name;

	public ResultData() {
	}

	public ResultData(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
