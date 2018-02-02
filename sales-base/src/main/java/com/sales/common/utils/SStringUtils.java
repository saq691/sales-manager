package com.sales.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;

/**
 * 帮助工具类
 * 
 * @copyright: Copyright (c) 2018年1月18日 上午11:13:11
 * @author: sunaiqiang saq691@126.com
 * @version: 1.0
 */
public class SStringUtils {

	/**
	 * 
	 * @param path
	 * @return
	 */
	public static String getFileName(String path) {
		if (!StringUtils.isBlank(path)) {
			path = path.substring(path.lastIndexOf('/') + 1, path.length());
			return path;
		} else {
			return null;
		}
	}

	/**
	 * 给静态文件添加版本号，例如：?v=20150730115940
	 */
	public static String getVersion() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String version = format.format(new Date());
		return version;
	}

	/**
	 * 生成版权号，例如：2016
	 * 
	 * @return
	 */
	public static String getCopyright() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
		String copyright = format.format(new Date());
		return copyright;
	}
	
	/**
	 * 获取count个随机数
	 * 
	 * @param count
	 *            随机数个数
	 * @return
	 */
	public static String generateCode(int count) {
		StringBuffer sb = new StringBuffer();
		String str = "0123456789";
		Random r = new Random();
		for (int i = 0; i < count; i++) {
			int num = r.nextInt(str.length());
			sb.append(str.charAt(num));
			str = str.replace((str.charAt(num) + ""), "");
		}
		return sb.toString();
	}

}
