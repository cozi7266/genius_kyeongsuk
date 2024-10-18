package com.ssafy.selfexam.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/share")
public class O4share {
	// prefix 요청URI  suffix
	@GetMapping("/index")
	public void index() {}
	
	@GetMapping("/test1")
	public String test1(@ModelAttribute("u") User user) {
		System.out.println("user : " + user);
		return "share/index";
	}
	
	@GetMapping("/test2")
	public String test2(Model model) {
		model.addAttribute("msg", "공유1");
		model.addAttribute("hello", "하이~");
		return "share/index";
	}
	
	@GetMapping("/test3")
	public String test3(Map<String, String> map) {
		map.put("msg", "맵 공유1");
		map.put("hello", "맵 하이~");
		return "share/index";
	}
}
