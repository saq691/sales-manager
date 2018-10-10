package com.sales.wap.controller.category;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 商城分类View控制器
 * 
 * @copyright: Copyright (c) 2018年9月23日 下午9:04:58
 * @author: sunaiqiang saq691@126.com
 * @version: 1.0
 */
@Controller
public class CategoryController {
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("category")
	public ModelAndView category(){
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("category");
		return mv;
	}
	
}
