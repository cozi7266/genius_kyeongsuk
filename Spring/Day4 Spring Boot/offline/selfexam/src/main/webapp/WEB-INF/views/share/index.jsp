<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>데이터 공유</h2>
	<h2>공유된 데이터 확인 : ${u}</h2>
	<h2>
		<a href="${pageContext.request.contextPath}/share/test1?id=abcd&password=1111">
			ModelAttribute 공유
		</a>
	</h2>
	<h2>
		<a href="${pageContext.request.contextPath}/share/test2">
			ModelAttribute 공유
		</a>
	</h2>
	<div>${msg}:::${hello}</div>
	<h2>
		<a href="${pageContext.request.contextPath}/share/test3">
			Map 공유
		</a>
	</h2>
	 
</body>
</html>