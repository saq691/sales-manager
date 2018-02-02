package com.sales.common.utils;

import java.util.Locale;

/**
 * 获取国际化消息工具类
 * 
 * @copyright: Copyright (c) 2018年1月18日 上午11:11:14
 * @author: sunaiqiang saq691@126.com
 * @version: 1.0
 */
public class MessageUtils {

	public static String getMessage(String code, Object[] args,
			String defaultMessage, Locale locale) {
		String msg = SpringUtils.getApplicationContext().getMessage(code, args,
				defaultMessage, locale);
		return msg != null ? msg.trim() : msg;
	}

	public static String getMessage(String code) {
		return getMessage(code, null, null, Locale.CHINA);
	}

}
