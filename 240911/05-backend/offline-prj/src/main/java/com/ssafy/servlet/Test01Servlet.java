package com.ssafy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 서블릿 클래스를 호출할 수 있게 주소 설정
// 서블릿의 주소 설정시 "/"로 시작하게 만들자.. 안만들면 문제 발생(확장자 패턴 제외)
// URL로 설정된 주소를 호출
// protocol://host:port/프로젝트주소/기능주소
// http://localhost:8080/offline-prj/test01
@WebServlet("/test01")
//public class Test01Servlet extends MyServlet {
//public class Test01Servlet extends GenericServlet {
public class Test01Servlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = response.getOutputStream();
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("	<title>first</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<h2>서블릿 호출 - Servlet Call");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
// Servlet <- GenericServlet <- HttpServlet


























//             http://localhost:8080/offline-prj/test01
//             -----------------  
//   Client                       Server
//   
//    							1 - WerServer   - offline-prj 
//    													- Test01Servlet(/test01)   
//    											- trip-prj
//    											- movie-prj
//    							
//    							
//    							
//    							2 - DBServer
//    							
//    							3 - FTP








