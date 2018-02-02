package com.sales.common.exception;

/**
 * 基本的自定义运行时异常
 * 
 * @Copyright: Copyright (c) 2018年1月18日 上午10:50:19
 * @Author: sunaiqiang saq691@126.com
 * @Version: 1.0
 */
public class BaseException extends RuntimeException {

	private static final long serialVersionUID = 8984571387720954464L;

	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public BaseException(String message) {
		super(message);
	}

	public BaseException() {
		super();
	}

	public BaseException(Throwable cause) {
		super(cause);
	}

}
