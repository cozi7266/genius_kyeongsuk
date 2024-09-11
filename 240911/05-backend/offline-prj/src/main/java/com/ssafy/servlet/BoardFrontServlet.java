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

@WebServlet("/mvc/board")
public class BoardFrontServlet extends HttpServlet {
	private List<Board> boards = new ArrayList<>();

	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		http://localhost:8080/offline-prj/mvc/board   
		String type = req.getParameter("type");
		if (type == null)
			type = "list";

		switch (type) {
		case "list":
			list(req, resp);
			break;
		case "write":
			write(req, resp);
			break;
		case "writeForm":
			writeForm(req, resp);
			break;
		}

	}

	/**
	 * 게시글 등록 http://localhost:8080/offline-prj/mvc/board body부분에
	 * type=write&title=~~&content=~~&writer=~~
	 */
	private void writeForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String html = """
			<!DOCTYPE html>
			<html>
			<head>
			<meta charset="UTF-8">
			<title>Insert title here</title>
			<style>
				textarea {
					width: 500px;
					height: 200px;
				}
			</style>
			
			</head>
			<body>
				<!--  게시판 등록폼 작성 -->
				<!--  필수 : 제목, 내용, 작성자 -->
				<form action="http://localhost/offline-prj/mvc/board" method="post">
					<input type="hidden" name="type" value="write" />
					<div>
						<label>제목</label>
						<input type="text" name="title" />
					</div>
					<div>
						<label>작성자</label>
						<input type="text" name="writer" />
					</div>
					<div>
						<label>내용</label>
						<textarea name="content"></textarea>
					</div>
					<div>
						<button>등록</button>
					</div>
				</form>
			</body>
			</html>			
		""";
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println(html);
		out.close();
	}

	private void write(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boards.add(new Board(req.getParameter("title"), req.getParameter("writer"), req.getParameter("content")));
		String html = """
			<html>
				<head><title>등록</title>
				<body>
					<script>
						alert("등록되었습니다");
						location.href = "http://localhost/offline-prj/mvc/board";
					</script>
				</body>
			</html>			
		""";
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println(html);
		out.close();
	}

	/**
	 * 게시글 목록 http://localhost:8080/offline-prj/mvc/board?type=list
	 */
	private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		if (boards.isEmpty()) {
			trHtml = "<tr><td colspan='3'>게시글이 존재하지 않습니다.</td></tr>";
		}
		
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("""
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
						<a href="http://localhost/offline-prj/mvc/board?type=writeForm">글쓰기</a>
					</body>
				</html>
				""".formatted(trHtml));
		out.close();
	}

}
