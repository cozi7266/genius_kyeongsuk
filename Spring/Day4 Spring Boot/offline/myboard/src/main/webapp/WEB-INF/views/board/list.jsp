<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시판 정보</h2>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>내용</th>
			<th>조회수</th>
			<th>등록일</th>
		</tr>
		<c:forEach var="board" items="${list}">
		<tr>
			<td>${board.no}</td>
			<td>${board.title}</td>
			<td>${board.writer}</td>
			<td>${board.content}</td>
			<td>${board.viewCnt}</td>
			<td>${board.regDate}</td>
		</tr>
		</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath}/board/register">글 등록</a>
</body>
</html>