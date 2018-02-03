package com.sales.web.controller;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Maps;
import com.sales.common.model.ResponseData;
import com.sales.common.page.Pager;
import com.sales.goods.entity.Goods;
import com.sales.goods.service.IGoodsService;

/**
 * 
 * @copyright: Copyright (c) 2018年1月18日 下午12:35:17
 * @author: sunaiqiang saq691@126.com
 * @version: 1.0
 */
@RestController
@RequestMapping("goods")
public class GoodsController {

	@Autowired
	private IGoodsService goodsService;

	// 商品代码
	private String goodsSku = "k0006";
	
	@GetMapping("/{id}")
	public Object get(@PathVariable("id") Integer id) {
		String msg = "";
		if (id == null) {
			msg = "商品ID不能为空";
			return msg;
		}
		Goods goods = new Goods();
		goods.setId(id);
		goods = goodsService.get(goods);
		return goods;
	}
	
	@GetMapping("/goods")
	public Object goods() {
		List<Goods> list = goodsService.listAll();
		return list;
	}

	/**
	 * 
	 * @return
	 */
	@GetMapping("/goodsPager")
	public Map<String, Object> getGoodsById(Pager pager) {
		Map<String, Object> sqlParameter = Maps.newHashMap();
		// 返回数据结果
		Map<String, Object> result = this.goodsService.listGoods(sqlParameter, pager);
		return result;
	}

	@PostMapping("/save")
	public String save() {
		this.goodsService.saveGoods();
		return "事务回滚成功！！！";
	}

	@PostMapping("/seckill")
	public ResponseData testSeckillDB() {
		for (int i = 0; i < 100; i++) {
			Thread t = new Thread(new Customer(1));
			t.start();
			latch.countDown();
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ResponseData responseData = new ResponseData();
		responseData.setMsg("卖出去商品------" + allCount + "*****顾客数量--------" + manCount);
		return responseData;
	}

	// 启动线程数
	private CountDownLatch latch = new CountDownLatch(300);
	// 购买总数量
	private Integer allCount = 0;
	// 顾客数量
	private Integer manCount = 0;

	private class Customer implements Runnable {
		// 每个客户购买数量
		private Integer count;

		public Customer(Integer count) {
			this.count = count;
		}

		public void run() {
			try {
				// 线程等待
				latch.await();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			boolean status = goodsService.updateGoodsNumByGoodsSku(goodsSku, count);

			if (status) {
				synchronized (allCount) {
					allCount += count;
					manCount++;
				}
			}
		}
	}

}
