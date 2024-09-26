<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
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
		<c:forEach var="b" items="${list}">
		<tr>
			<td>${b.no}</td>
			<td><a href="${pageContext.request.contextPath}/board?action=detail&no=${b.no}">${b.title}</a></td>
			<td>${b.writer}</td>
			<td>${b.viewCnt}</td>
		</tr>
		</c:forEach>
		
	</table>
	<a href="${pageContext.request.contextPath}/board?action=writeForm">글쓰기</a>	
</body>
</html>





















