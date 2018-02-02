package com.sales.common.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.util.PropertyPlaceholderHelper;

/**
 * 初始化系统是默认加载配置文件perpoties工具类
 * 
 * @copyright: Copyright (c) 2017年12月6日 下午3:52:13
 * @author: sunaiqiang saq691@126.com
 * @version: 1.0
 */
public class ConfigUtils extends PropertyPlaceholderConfigurer {
	private static Map<String, String> properties = new HashMap<String, String>();

	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
			throws BeansException {
		// cache the properties
		PropertyPlaceholderHelper helper = new PropertyPlaceholderHelper(DEFAULT_PLACEHOLDER_PREFIX,
				DEFAULT_PLACEHOLDER_SUFFIX, DEFAULT_VALUE_SEPARATOR, false);
		for (Entry<Object, Object> entry : props.entrySet()) {
			String stringKey = String.valueOf(entry.getKey());
			String stringValue = String.valueOf(entry.getValue());
			stringValue = helper.replacePlaceholders(stringValue, props);
			properties.put(stringKey, stringValue);
		}
		super.processProperties(beanFactoryToProcess, props);
	}

	public static Map<String, String> getProperties() {
		return properties;
	}

	public static String getProperty(String key) {
		return properties.get(key);
	}

	/**
	 * 获取阿里云OSS存储文件地址
	 * 
	 * @return
	 */
	public static String getOssServername() {
		return ConfigUtils.getProperty("oss.servername");
	}

	/**
	 * 获取后台Host地址
	 * 
	 * @return
	 */
	public static String getPlatformServername() {
		return ConfigUtils.getProperty("platform.servername");
	}

	/**
	 * 获取官网Host地址
	 * 
	 * @return
	 */
	public static String getWebServername() {
		return ConfigUtils.getProperty("web.servername");
	}

	/**
	 * 
	 * @return
	 */
	public static String getOssAccessKeyId() {
		return ConfigUtils.getProperty("ossConfig.accessKeyId");
	}

	/**
	 * 
	 * @return
	 */
	public static String getOssAccessKeySecret() {
		return ConfigUtils.getProperty("ossConfig.accessKeySecret");
	}

	/**
	 * 
	 * @return
	 */
	public static String getOssRemoteEndpoint() {
		return ConfigUtils.getProperty("ossConfig.remoteEndpoint");
	}

	/**
	 * 
	 * @return
	 */
	public static String getOssBucketName() {
		return ConfigUtils.getProperty("ossConfig.bucketName");
	}

	/**
	 * 
	 * @return
	 */
	public static String getOssBaseUrl() {
		return ConfigUtils.getProperty("ossConfig.baseURL");
	}

}
