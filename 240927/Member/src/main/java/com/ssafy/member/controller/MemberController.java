package com.ssafy.member.controller;

import com.ssafy.member.model.service.MemberService;
import com.ssafy.member.model.service.MemberServiceImpl;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet("/member")
public class MemberController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private MemberService service = MemberServiceImpl.getInstance();

}
