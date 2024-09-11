package com.ssafy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 사용자의 요청
// http://localhost:8080/offline-prj/self01
// 사용자의 브라우져로 본인의 이름을 전송한다.
@WebServlet("/self01")
public class Self01Servlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(
		"""
			<!DOCTYPE html>
			<html lang="en">
			<head>
			  <meta charset="UTF-8">
			  <meta name="viewport" content="width=device-width, initial-scale=1.0">
			  <title>Document</title>
			</head>
			<body>
			  <h2>대전4반 싸피</h2>
			</body>
			</html>	
		""");
		out.close();
	}
}












