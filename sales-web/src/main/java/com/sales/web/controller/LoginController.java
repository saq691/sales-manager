package com.sales.web.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.sales.web.model.LoginModel;

/**
 * 
 * @copyright: Copyright (c) 2018年1月18日 下午12:35:17
 * @author: sunaiqiang saq691@126.com
 * @version: 1.0
 */
@Controller
public class LoginController {

	/**
	 * 登录页面
	 * 
	 * @return
	 */
	@GetMapping(value = "login.html")
	public String login() {
		return "/login";
	}

	@GetMapping("loginForm")
	public String loginForm(@Valid @ModelAttribute("loginModel") LoginModel loginModel,BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			//错误消息
			return "/login";
		}
		return "/index";
	}
	
}
