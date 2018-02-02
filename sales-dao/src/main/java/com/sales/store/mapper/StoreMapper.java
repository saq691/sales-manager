package com.sales.store.mapper;

import org.springframework.stereotype.Repository;

import com.sales.common.mapper.IBaseMapper;
import com.sales.store.entity.Store;

/**
 * 
 * 
 * @copyright: Copyright (c) 2018年1月18日 上午11:50:05
 * @author: sunaiqiang saq691@126.com
 * @version: 1.0
 */
@Repository("storeMapper")
public interface StoreMapper extends IBaseMapper<Store, Integer> {

}