package com.ssafy.ws.step2.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.ssafy.ws.step2.dto.Movie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 이 서블릿이 호출되기 위해서는 url 상에 http://server_ip:port/context_name/main 이 필요하다.

@WebServlet("/main")
public class MainServlet extends HttpServlet{
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		String action = req.getParameter("action");
		if("regist".equals(action)) {
			doRegist(req, res);
		}		
	}
	
	public void doRegist(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		// 해야할 일...
		String title = req.getParameter("title");
		String director = req.getParameter("director");
		String genre = req.getParameter("genre");
		int runningTime = Integer.parseInt(req.getParameter("runningTime"));
		Movie movie = new Movie(1, title, director, genre, runningTime);
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("""
			<html>
				<head><title>영화정보</title></head>
				<body>
					<h2>영화정보</h2>
					<p>%s</p>		
				</body>
			</html>	
		""".formatted(movie));
		out.close();
	}
}
