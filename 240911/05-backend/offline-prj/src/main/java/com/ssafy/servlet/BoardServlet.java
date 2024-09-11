package com.ssafy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	private List<Board> boards = new ArrayList<>();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boards.add(
			new Board(
				req.getParameter("title"), 
				req.getParameter("writer"), 
				req.getParameter("content")
			)
		);
		String trHtml = "";
		for (Board b : boards) {
			trHtml += """
			<tr>
				<td>%d</td>
				<td>%s</td>
				<td>%s</td>
			</tr>	
			""".formatted(b.getNo(), b.getTitle(), b.getWriter());
		}
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println(
				"""
				<html>
					<head><title>게시판 목록</title></head>
					<body>
						<h2>대전 4반 게시판</h2>
						<table>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>글쓴이</th>
							</tr>
							%s
						</table>
						<a href="http://192.168.210.40:8080/offline-prj/board.html">글쓰기</a>
					</body>
				</html>
				""".formatted(trHtml)
		);
		out.close();
	}
	
/*
 	사용자가 전송한 제목, 내용, 작성자 파라미터 꺼낸다.
 	꺼낸 데이터를 사용자에게 확인 시켜준다.
 	
 	-------------------------
 	번호		제목			작성자
 	-------------------------
 	1		작성한 제목	작성한 이름
 	------------------------- 	
 
 */
}
