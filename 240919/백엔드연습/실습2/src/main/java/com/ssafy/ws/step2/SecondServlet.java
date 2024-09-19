package com.ssafy.ws.step2;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Q. HttpServlet을 상속받고, 경로가 "/second"인 @WebServlet을 작성해 봅시다.
@WebServlet("/second")
public class SecondServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// first page 라는 문자열을 출력한다.
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>second page</h1>");
		writer.println("</body>");
		writer.println("</html>");
		writer.close();
	}
}
