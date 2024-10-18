package com.ssafy.selfexam.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/param")
public class O2Parameter {
	@GetMapping("test1")
	public String test1(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		return "param/index";
	}
	
	public String test2(@RequestParam String id, 
			            @RequestParam(value = "password") String pass,
			            @RequestParam(required = false) String name,
			            @RequestParam(defaultValue ="ssafy@ssafy.com") String email) {
		System.out.println(id + " , " + pass + " , " + name + " , " + email);
		return "param/index";
	}
	
	
	@GetMapping("test3")
	public String test3(@RequestParam Map<String, String> map) {
		System.out.println(map);
		System.out.println(map.get("id") + " , " + map.get("password"));
		return "param/index";
	}
	
	@GetMapping("test4")
	public String test4(User user) {
		System.out.println(user);
		return "param/index";
	}
	
	
	@GetMapping("index")
	public String index() {
		// /WEB-INF/views/param/index.jsp
		return "param/index";
	}
}
