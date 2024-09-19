package com.ssafy.ws.step2;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


// Q. HttpServlet를 상속받아 봅시다.
//	  @WebServlet Annotation은 작성하지 않습니다.
//    ./src/main/webapp/WEB-INF/web.xml 에 등록합니다.
public class FirstServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>first page</h1>");
		writer.println("</body>");
		writer.println("</html>");
		writer.close();
	}
}
