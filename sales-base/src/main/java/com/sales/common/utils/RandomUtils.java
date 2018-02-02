package com.sales.common.utils;

import java.util.UUID;

/**
 * 32位UUID生成工具类
 * 
 * @copyright: Copyright (c) 2018年1月18日 上午11:11:31
 * @author: sunaiqiang saq691@126.com
 * @version: 1.0
 */
public class RandomUtils {

	/**
	 * 获取32位的uuid字符串
	 * 
	 * @return
	 */
	public static String getGenerateId() {
		return UUID.randomUUID().toString().replace("-", "");
	}

}