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
	<h2>
		<a href ="${pageContext.request.contextPath}/param/index">O2param 테스트 페이지 이동하기</a>
	</h2>
	<h2>
		<a href ="${pageContext.request.contextPath}/pagemove/index">O3pagemove 테스트 페이지 이동하기</a>
	</h2>
	<h2>
		<a href ="${pageContext.request.contextPath}/share/index">O4share 테스트 페이지 이동하기</a>
	</h2>
	
</body>
</html>