package com.ssafy.selfexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/pagemove")
public class O3PageMove {
	
//	3. 모델앤뷰 객체 사용
	@GetMapping("/index")
	public ModelAndView index() {
//		1.
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("msg", "하이 스프링부트");
//		mav.setViewName("pagemove/index");
//		return mav;
		
//		2.
		return new ModelAndView("pagemove/index");
	}
	
	
//  2. void 이용 (권장 x -> 가독성이 떨어짐)
//	@GetMapping("/index")
//	public void index() {}

	
// 	1. String 이용
//	@GetMapping("/index")
//	public String index() {
//		// WEB-INF/views/pagemove/index.jsp
//		return "pagemove/index";
//	}
 	
	
	
}
