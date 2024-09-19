package com.ssafy.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;characterset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.write("<html>");
		writer.write("<head>");
		writer.write("<title>Hello! SSAFY!</title>");
		writer.write("</head>");
		writer.write("<body>");
		writer.write("<h1>Hello! Servlet</h1>");
		writer.write("<p>Hello! SSAFY</p>");
		writer.write("</body>");
		writer.write("</html>");
		
	}
}
