package com.sales.common.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.sales.common.page.Pager;

/**
 * 基础业务层接口，包括增、删、改、查、分页等方法
 * 
 * @copyright: Copyright (c) 2018年1月18日 上午11:13:49
 * @author: sunaiqiang saq691@126.com
 * @version: 1.0
 */
public interface IBaseService<T, ID extends Serializable> {

	/**
	 * 添加实体对象
	 *
	 * @param entity
	 *            实体对象
	 * @return true/false 标记
	 */
	boolean save(T entity);

	/**
	 * 批量添加实体对象
	 *
	 * @param list
	 *            实体对象数组
	 * @return true/false 标记
	 */
	boolean batchSave(List<T> list);

	/**
	 * 更新实体对象
	 *
	 * @param entity
	 *            实体对象
	 * @return true/false 标记
	 */
	boolean update(T entity);

	/**
	 * 删除实体对象
	 *
	 * @param entity
	 *            实体对象
	 * @return true/false 标记
	 */
	boolean remove(T entity);

	/**
	 * 根据ids批量删除实体对象
	 *
	 * @param ids
	 *            id数组
	 * @return true/false 标记
	 */
	boolean batchRemove(ID[] ids);

	/**
	 * 查询实体对象
	 *
	 * @param entity
	 *            实体对象
	 * @return T 实体对象
	 */
	T get(T entity);

	/**
	 * 根据id查询唯一实体对象
	 *
	 * @param id
	 *            传入id参数
	 * @return T 实体对象
	 */
	T getById(ID id);

	/**
	 * 根据id列表查询对象
	 *
	 * @param ids
	 *            id列表
	 * @return 实体列表
	 */
	List<T> listByIds(List<ID> ids);

	/**
	 * 查询所有实体对象
	 *
	 * @return 实体列表
	 */
	List<T> listAll();

	/**
	 * 根据Mapper接口查询方法，分页查询
	 * 
	 * @param sqlParameter
	 * @param pager
	 * @return
	 */
	Map<String, Object> listPage(PageList<T> pageList, Pager pager);

}
