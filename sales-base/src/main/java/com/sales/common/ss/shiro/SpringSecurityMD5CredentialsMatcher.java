package com.sales.common.ss.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

import com.sales.common.utils.SSEncryptionUtils;

/**
 * 实现自定义的加密算法（Spring Security的MD5加密算法）
 * 
 * @copyright: Copyright (c) 2018年1月18日 上午11:42:11
 * @author: sunaiqiang saq691@126.com
 * @version: 1.0
 */
public class SpringSecurityMD5CredentialsMatcher extends SimpleCredentialsMatcher {

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {

		// token.getCredentials()实际类型为字符数组
		char[] credentials = (char[]) token.getCredentials();

		// 字符数组转字符串
		String credentialsStr = new String(credentials);

		// Spring Security的MD5加密
		Object tokenCredentials = SSEncryptionUtils.saltMD5Encoder(credentialsStr);
		Object accountCredentials = getCredentials(info);
		return equals(tokenCredentials, accountCredentials);
	}
}
