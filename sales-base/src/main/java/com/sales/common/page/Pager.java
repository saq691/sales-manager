package com.sales.common.page;

import com.sales.common.enums.PagerEnum;
import com.sales.common.model.BaseModel;

/**
 * 分页对象实体类
 * 
 * @copyright: Copyright (c) 2018年1月18日 上午11:15:41
 * @author: sunaiqiang saq691@126.com
 * @version: 1.0
 */
public class Pager extends BaseModel {
	/**
	 *
	 */
	private static final long serialVersionUID = -3361651088667088509L;

	/**
	 * 开始页
	 */
	private int currentPage;

	/**
	 * 每页大小
	 */
	private int pageSize;

	/**
	 * 分页插件已经处理sql注入的问题 ex: "id.asc,code.desc" or "code.desc"
	 */
	private String orderSegment;

	public Pager() {

	}

	public Pager(int currentPage, int pageSize) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}

	public Pager(int currentPage, int pageSize, String orderSegment) {
		this(currentPage, pageSize);
		this.orderSegment = orderSegment;
	}

	public int getCurrentPage() {
		try {
			if (currentPage <= 0) {
				currentPage = PagerEnum.PAGE.getValue();
			}
		} catch (RuntimeException e) {
			currentPage = PagerEnum.PAGE.getValue();
		}
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		try {
			if (pageSize <= 0) {
				pageSize = PagerEnum.LIMIT_10.getValue();
			}
		} catch (RuntimeException e) {
			pageSize = PagerEnum.LIMIT_10.getValue();
		}
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getOrderSegment() {
		return orderSegment;
	}

	public void setOrderSegment(String orderSegment) {
		this.orderSegment = orderSegment;
	}

}
