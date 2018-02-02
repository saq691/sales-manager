package com.sales.common.mapper;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.sales.common.exception.BaseException;

/**
 * 基础dao接口Mapper类
 * 
 * @copyright: Copyright (c) 2018年1月18日 上午11:18:35
 * @author: sunaiqiang saq691@126.com
 * @version: 1.0
 */
public interface IBaseMapper<T, ID extends Serializable> {

	/**
	 * 
	 * @param entity
	 * @return
	 * @throws BaseException
	 */
	void save(T entity) throws BaseException;

	/**
	 * 
	 * @param list
	 * @return
	 * @throws BaseException
	 */
	void batchSave(List<T> list) throws BaseException;

	/**
	 * 
	 * @param entity
	 * @return
	 * @throws BaseException
	 */
	void update(T entity) throws BaseException;

	/**
	 * 
	 * @param entity
	 * @return
	 * @throws BaseException
	 */
	void remove(T entity) throws BaseException;

	/**
	 * 
	 * @param ids
	 * @return
	 * @throws BaseException
	 */
	void batchRemove(ID[] ids) throws BaseException;

	/**
	 * 
	 * @param entity
	 * @return
	 * @throws BaseException
	 */
	T get(T entity) throws BaseException;

	/**
	 * 
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	T getById(ID id) throws DataAccessException;

	/**
	 * 
	 * @return
	 * @throws BaseException
	 */
	List<T> listAll() throws BaseException;

	/**
	 * 
	 * @param ids
	 * @return
	 * @throws BaseException
	 */
	List<T> listByIds(List<ID> ids) throws BaseException;

}