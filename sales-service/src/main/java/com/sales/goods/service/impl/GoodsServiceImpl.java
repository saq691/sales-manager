package com.sales.goods.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.google.common.collect.Maps;
import com.sales.common.enums.PagerEnum;
import com.sales.common.exception.BaseException;
import com.sales.common.mapper.IBaseMapper;
import com.sales.common.page.Pager;
import com.sales.common.service.impl.BaseServiceImpl;
import com.sales.goods.entity.Goods;
import com.sales.goods.mapper.GoodsMapper;
import com.sales.goods.service.IGoodsService;

/**
 * 
 * 
 * @copyright: Copyright (c) 2018年1月18日 上午11:56:26
 * @author: sunaiqiang saq691@126.com
 * @version: 1.0
 */
@Service("goodsService")
public class GoodsServiceImpl extends BaseServiceImpl<Goods, Integer> implements IGoodsService {

	private static Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);

	@Autowired
	private GoodsMapper goodsMapper;

	@Override
	public IBaseMapper<Goods, Integer> getBaseMapper() {
		return goodsMapper;
	}

	@Override
	@Transactional
	public boolean saveGoods() {
		try {
			for (int i = 1; i <= 10; i++) {
				Goods goods = new Goods();
				goods.setGoodsName("小苹果" + i);
				goods.setGoodsNum(100);
				goods.setStoreId(3);
				this.save(goods);
				if (i == 2) {
					throw new RuntimeException("111");
				}
			}
		} catch (BaseException e) {
			throw new RuntimeException(e);
		}
		return false;
	}

	@Override
	public Map<String, Object> listGoods(Map<String, Object> sqlParameter, Pager pager) {
		int currentPage = PagerEnum.PAGE.getValue();
		int pageSize = PagerEnum.LIMIT_10.getValue();
		if (pager != null) {
			// 当前页
			if (pager.getCurrentPage() <= 0) {
				pager.setCurrentPage(PagerEnum.PAGE.getValue());
			}

			// 每页大小
			if (pager.getPageSize() <= 0) {
				pager.setPageSize(PagerEnum.LIMIT_10.getValue());
			}
			currentPage = pager.getCurrentPage();
			pageSize = pager.getPageSize();
		}
		PageBounds pageBounds = new PageBounds(currentPage, pageSize);
		PageList<Goods> pageList = this.goodsMapper.listGoods(sqlParameter, pageBounds);

		// 返回数据结果
		Map<String, Object> result = this.listPage(pageList, pager);
		return result;
	}

	@Override
	public Goods getByGoodsSku(String goodsSku) {
		try {
			Goods goods = goodsMapper.getByGoodsSku(goodsSku);
			return goods;
		} catch (BaseException e) {
			logger.error("根据商品SKU查询商品信息查询失败{}：", e.getMessage());
			return null;
		}
	}

	@Override
	@Transactional
	public boolean removeByGoodsSku(String goodsSku) {
		boolean status = false;
		try {
			this.goodsMapper.removeByGoodsSku(goodsSku);
			status = true;
		} catch (BaseException e) {
			logger.error("根据商品SKU删除商品异常{}：", e.getMessage());
			status = false;
			throw e;
		}
		return status;
	}

	@Override
	@Transactional
	public boolean updateGoodsNumByGoodsSku(String goodsSku, Integer count) {
		boolean status = false;
		try {
			Map<String, Object> sqlParamter = Maps.newHashMap();
			sqlParamter.put("goodsSku", goodsSku);
			sqlParamter.put("goodsNum", count);
			Integer result = this.goodsMapper.updateGoodsNumByGoodsSku(sqlParamter);
			if (result.equals(PagerEnum.LIMIT_1.getValue())) {
				status = true;
			}
		} catch (BaseException e) {
			logger.error("更新商品库存异常{}：", e.getMessage());
			status = false;
			throw e;
		}
		return status;
	}

}
