package com.sales.common.converter;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 日期转换类工具类
 * 
 * @copyright: Copyright (c) 2017年12月6日 下午11:48:08
 * @author: sunaiqiang saq691@126.com
 * @version: 1.0
 */
public class DateEditor extends PropertyEditorSupport {

	private static final List<String> FORMARTS = new ArrayList<String>(2);

	static {
		FORMARTS.add("yyyy-MM-dd");
		FORMARTS.add("yyyy-MM-dd HH:mm:ss");
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		SimpleDateFormat format = new SimpleDateFormat(FORMARTS.get(1));
		Date date = null;
		try {
			date = format.parse(text);
		} catch (ParseException e) {
			format = new SimpleDateFormat(FORMARTS.get(0));
			try {
				date = format.parse(text);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		setValue(date);
	}

}