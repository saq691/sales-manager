package com.sales.goods.service;

import java.util.Map;

import com.sales.common.page.Pager;
import com.sales.common.service.IBaseService;
import com.sales.goods.entity.Goods;

/**
 * 
 * 
 * @copyright: Copyright (c) 2018年1月18日 上午11:56:26
 * @author: sunaiqiang saq691@126.com
 * @version: 1.0
 */
public interface IGoodsService extends IBaseService<Goods, Integer> {

	/**
	 * 保存方法
	 * 
	 * @return
	 */
	boolean saveGoods();

	/**
	 * 根据sqlParameter设置参数查询分页方法
	 * 
	 * 返回数据对象格式： 
	 * {
	 *   "paginator":{
	 *       "limit":10,
	 *       "page": 1,
	 *       "totalCount": 6,
	 *       "offset": 0,
	 *       "startRow": 1,
	 *       "endRow": 6,
	 *       "slider":[1],
	 *       "firstPage": true,
	 *       "lastPage": true,
	 *       "nextPage": 1,
	 *       "hasPrePage": false,
	 *       "prePage": 1,
	 *       "hasNextPage":false,
	 *       "totalPages": 1
	 *   }, 
	 *   "items":[
	 *       {
	 *           "id":5
	 *       }
	 *   ] 
	 * }
	 * 
	 * @param sqlParameter
	 * @param pager
	 * @return
	 */
	Map<String, Object> listGoods(Map<String, Object> sqlParameter, Pager pager);

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
	 *            商品SKU
	 * @return
	 */
	boolean removeByGoodsSku(String goodsSku);

	/**
	 * 更新商品库存,基于数据库乐观锁机制的秒杀 基于数据库乐观锁机制的秒杀,主要是通过控制数据版本修改数据
	 * 
	 * 优点: 简单、准确 可靠性高 缺点: 并发低,基于DDS机械硬盘的并发约为 700,HDS并发约为 300 这是一个平均值。
	 * 
	 * @param goodsSku
	 *            商品SKU
	 * @param count
	 *            购买数量
	 * @return
	 */
	boolean updateGoodsNumByGoodsSku(String goodsSku, Integer count);

}
