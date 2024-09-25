package com.ssafy.exam.member.controller;

import java.io.IOException;

import com.ssafy.exam.member.model.dao.MemberDAO;
import com.ssafy.exam.member.model.dao.MemberDAOImpl;
import com.ssafy.exam.member.model.dto.Member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/member")
public class MemberController extends HttpServlet {
	
	private MemberDAO memberDao;
	public MemberController() {
		memberDao = MemberDAOImpl.getInstance();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if ("join".equals(action)) {
			// 목록 페이지
			join(req, resp);
		} else if ("joinForm".equals(action)) {
			// 목록 페이지
			joinForm(req, resp);
		} else if ("loginForm".equals(action)) {
			// 목록 페이지
			loginForm(req, resp);
		} else if ("login".equals(action)) {
			// 목록 페이지
			login(req, resp);
		} else if ("logout".equals(action)) {
			// 목록 페이지
			logout(req, resp);
		} 
	}

	private void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.invalidate();
		resp.sendRedirect(req.getContextPath() + "/main");
	}

	private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		Member param = new Member();
		param.setId(id);
		param.setPassword(password);
		// member가 null일 경우 : id 또는 password 가 틀린 경우 - 로그인 실패
		// null이 아닐 경우 : 로그인 성공
		Member member = memberDao.selectMember(param);
		String path = "/member?action=loginForm";
		if (member != null) {  // 로그인 성공 : 로그인 상태를 저장하자
			path = "/main";
			HttpSession session = req.getSession();
			session.setAttribute("memberInfo", member);
		}
		resp.sendRedirect(req.getContextPath() + path);
	}

	private void loginForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/member/login.jsp");
		rd.forward(req, resp);
	}

	private void joinForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// /member?action=joinForm
		// /member/join.jsp 이동해야 한다.
		RequestDispatcher rd = req.getRequestDispatcher("/member/join.jsp");
		rd.forward(req, resp);
	}

	/**
	 * 회원가입 처리
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void join(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		Member member = new Member(id, name, password);
		memberDao.insertMember(member);
		
		resp.sendRedirect(req.getContextPath() + "/member?action=loginForm");
	}
}













