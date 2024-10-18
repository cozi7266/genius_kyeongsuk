<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과</title>
</head>
<body>
	<a href="/img/${fileName}">${fileName}</a>
	<img src="/img/${fileName}">
	
	
	<!-- "이미지다운로드" 링크를 누르면 "download"라는 요청이 DispatcherServlet으로 날아가는데 다음 querystring 으로 날아간다. -->
	<a href="/download?fileName=${fileName}">이미지다운로드</a>
	
</body>
</html>