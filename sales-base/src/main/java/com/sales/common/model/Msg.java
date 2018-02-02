package com.sales.common.model;

/**
 * 消息实体Model类
 * 
 * @copyright: Copyright (c) 2018年1月18日 上午11:17:10
 * @author: sunaiqiang saq691@126.com
 * @version: 1.0
 */
public class Msg extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4910991228083128728L;

	/**
	 * 消息名称
	 */
	private String name;

	/**
	 * 消息信息
	 */
	private String msg;

	public Msg() {
		super();
	}

	public Msg(String name, String msg) {
		super();
		this.name = name;
		this.msg = msg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
