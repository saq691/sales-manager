package com.sales.wap.controller.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 账户中心View相关
 * 
 * @copyright: Copyright (c) 2018年9月23日 下午9:42:30
 * @author: sunaiqiang saq691@126.com
 * @version: 1.0
 */
@Controller
@RequestMapping("account")
public class AccountController {

	/**
	 * 我的首页
	 * @return
	 */
	@GetMapping("mine")
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("account/mine");
		return mv;
	}
	
	/**
	 * 收藏商品
	 * 
	 * @return
	 */
	@GetMapping("hoard")
	public ModelAndView hoard(){
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("account/hoard");
		return mv;
	}
	
}
