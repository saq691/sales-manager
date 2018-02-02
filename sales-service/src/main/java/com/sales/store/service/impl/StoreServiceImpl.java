package com.sales.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.common.mapper.IBaseMapper;
import com.sales.common.service.impl.BaseServiceImpl;
import com.sales.store.entity.Store;
import com.sales.store.mapper.StoreMapper;
import com.sales.store.service.IStoreService;

/**
 * 
 * 
 * @copyright: Copyright (c) 2018年1月18日 上午11:56:26
 * @author: sunaiqiang saq691@126.com
 * @version: 1.0
 */
@Service("storeService")
public class StoreServiceImpl extends BaseServiceImpl<Store, Integer> implements IStoreService {

	@Autowired
	private StoreMapper storeMapper;

	@Override
	public IBaseMapper<Store, Integer> getBaseMapper() {
		return storeMapper;
	}

}
