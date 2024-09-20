<%@page import="com.ssafy.exam.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Board> list = (List<Board>)request.getAttribute("list");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>대전 4반 게시판</h2>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
		</tr>
		<%
			for(Board b : list) {
		%>
		<tr>
			<td><%= b.getNo() %></td>
			<td><%= b.getTitle() %></td>
			<td><%= b.getWriter() %></td>
			<td><%= b.getViewCnt() %></td>
		</tr>
		<%
			}
		%>
	</table>
	<a href="/board-step01-mvc/board?action=writeForm">글쓰기</a>	
</body>
</html>







