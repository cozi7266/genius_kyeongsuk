<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello JSP</title>
</head>
<body>
	<h1>파라미터</h1>
	
	<h2>
		<a href="${pageContext.request.contextPath}/param/test1?id=hong&password=1111">HttpServletRequest</a>
	</h2>
	<h2>
		<a href="${pageContext.request.contextPath}/param/test2?id=lee&password=2222">@RequestParam</a>
	</h2>
	<h2>
		<a href="${pageContext.request.contextPath}/param/test3?id=kim&password=3333">@RequestParam - test3 맵이용</a>
	</h2>
	<h2>
		<a href="${pageContext.request.contextPath}/param/test4?id=park&password=4444">@RequestParam - test4 DTO 객체 이용</a>
	</h2>
</body>
</html>