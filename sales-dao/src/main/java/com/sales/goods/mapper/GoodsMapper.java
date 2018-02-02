package com.sales.goods.mapper;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.sales.common.exception.BaseException;
import com.sales.common.mapper.IBaseMapper;
import com.sales.goods.entity.Goods;

/**
 * 
 * 
 * @copyright: Copyright (c) 2018年1月18日 上午11:49:39
 * @author: sunaiqiang saq691@126.com
 * @version: 1.0
 */
@Repository("goodsMapper")
public interface GoodsMapper extends IBaseMapper<Goods, Integer> {

	/**
	 * 根据sqlParameter设置参数查询分页方法
	 * 
	 * @param sqlParameter
	 * @param pageBounds
	 * @return
	 */
	PageList<Goods> listGoods(Map<String, Object> sqlParameter, PageBounds pageBounds);

	/**
	 * 根据商品SKU查询商品信息
	 * 
	 * @param goodsSku
	 *            商品SKU
	 * @return
	 */
	Goods getByGoodsSku(String goodsSku);

	/**
	 * 根据商品SKU删除商品
	 * 
	 * @param goodsSku
	 * @throws BaseException 商品SKU
	 */
	void removeByGoodsSku(String goodsSku) throws BaseException;

	/**
	 * 更新商品库存
	 * 
	 * @param sqlParamter
	 * @return
	 * @throws BaseException
	 */
	Integer updateGoodsNumByGoodsSku(Map<String, Object> sqlParamter) throws BaseException;

}