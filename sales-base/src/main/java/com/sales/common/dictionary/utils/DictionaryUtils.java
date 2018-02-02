package com.sales.common.dictionary.utils;

import java.util.ArrayList;
import java.util.List;

import com.sales.common.dictionary.model.ResultData;

/**
 * 枚举类转成List<ResultData>集合数据字典类
 * 
 * @copyright: Copyright (c) 2018年1月18日 上午10:49:35
 * @author: sunaiqiang saq691@126.com
 * @version: 1.0
 */
public class DictionaryUtils {
	/**
	 * 获得枚举定义的数据构建成List集合
	 * 
	 * @param enumType
	 * @return 返回List集合
	 */
	public static <E extends Enum<E>> List<ResultData> getEnumList(Class<E> enumType) {
		List<ResultData> list = new ArrayList<ResultData>();
		E[] enums = enumType.getEnumConstants();
		ResultData data = null;
		for (Enum<E> e : enums) {
			data = new ResultData();
			data.setId(Integer.toString(e.ordinal()));
			data.setName(e.toString());
			list.add(data);
		}
		return list;
	}

}
