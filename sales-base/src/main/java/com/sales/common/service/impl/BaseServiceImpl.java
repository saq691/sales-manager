package com.sales.common.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sales.common.exception.BaseException;
import com.sales.common.mapper.IBaseMapper;
import com.sales.common.page.Pager;
import com.sales.common.service.IBaseService;

/**
 * 基础业务层接口实现类，包括增、删、改、查、分页等方法
 * 
 * @copyright: Copyright (c) 2018年1月18日 上午11:14:03
 * @author: sunaiqiang saq691@126.com
 * @version: 1.0
 */
public abstract class BaseServiceImpl<T, ID extends Serializable> implements IBaseService<T, ID> {

	private static Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);

	public abstract IBaseMapper<T, ID> getBaseMapper();

	@Override
	public boolean save(T entity) {
		boolean status = false;
		try {
			this.getBaseMapper().save(entity);
			status = true;
		} catch (BaseException e) {
			logger.error("add操作异常-->{}", e.getMessage());
			status = false;
			throw e;
		}
		return status;
	}

	@Override
	public boolean batchSave(List<T> list) {
		boolean status = false;
		try {
			this.getBaseMapper().batchSave(list);
			status = true;
		} catch (BaseException e) {
			logger.error("batchAdd操作异常-->{}", e.getMessage());
			status = false;
			throw e;
		}
		return status;
	}

	@Override
	public boolean update(T entity) {
		boolean status = false;
		try {
			this.getBaseMapper().update(entity);
			status = true;
		} catch (BaseException e) {
			logger.error("update操作异常-->{}", e.getMessage());
			status = false;
			throw e;
		}
		return status;
	}

	@Override
	public boolean remove(T entity) {
		boolean status = false;
		try {
			this.getBaseMapper().remove(entity);
			status = true;
		} catch (BaseException e) {
			logger.error("delete操作异常-->{}", e.getMessage());
			status = false;
			throw e;
		}
		return status;
	}

	@Override
	public boolean batchRemove(ID[] ids) {
		boolean status = false;
		try {
			this.getBaseMapper().batchRemove(ids);
			status = true;
		} catch (BaseException e) {
			logger.error("batchDelete操作异常-->{}", e.getMessage());
			status = false;
			throw e;
		}
		return status;
	}

	@Override
	public T get(T entity) {
		try {
			return this.getBaseMapper().get(entity);
		} catch (BaseException e) {
			logger.error("get操作异常-->{}", e.getMessage());
			return null;
		}
	}

	@Override
	public T getById(ID id) {
		try {
			return this.getBaseMapper().getById(id);
		} catch (BaseException e) {
			logger.error("get操作异常-->{}", e.getMessage());
			return null;
		}
	}

	@Override
	public List<T> listAll() {
		List<T> list = Lists.newArrayList();
		try {
			list = this.getBaseMapper().listAll();
		} catch (BaseException e) {
			logger.error("getAll操作异常-->{}", e.getMessage());
		}
		return list;
	}

	@Override
	public List<T> listByIds(List<ID> ids) {
		List<T> list = Lists.newArrayList();
		try {
			list = this.getBaseMapper().listByIds(ids);
		} catch (BaseException e) {
			logger.error("getByIds操作异常-->{}", e.getMessage());
		}
		return list;
	}

	@Override
	public Map<String, Object> listPage(PageList<T> pageList, Pager pager) {
		Map<String, Object> data = Maps.newHashMapWithExpectedSize(2);
		if (pageList != null) {
			Paginator paginator = pageList.getPaginator();
			if (pager.getCurrentPage() > paginator.getTotalPages()) {
				pageList = new PageList<T>();
			}
			data.put("items", pageList);
			data.put("paginator", paginator);
		}
		return data;
	}

}
