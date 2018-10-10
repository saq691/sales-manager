package com.sales.wap.controller.shopcart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 购物车View相关
 * 
 * @copyright: Copyright (c) 2018年9月23日 下午9:00:16
 * @author: sunaiqiang saq691@126.com
 * @version: 1.0
 */
@Controller
public class ShopcartController {
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("shopcart")
	public ModelAndView shopcart(){
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("shopcart");
		return mv;
	}
	
}
