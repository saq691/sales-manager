package com.sales.wap.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 首页View控制层
 * 
 * @copyright: Copyright (c) 2018年9月23日 下午8:25:55
 * @author: sunaiqiang saq691@126.com
 * @version: 1.0
 */
@Controller
public class IndexController {

	/**
	 * 
	 * @return
	 */
	@GetMapping("index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("index");
		return mv;
	}
	
}
