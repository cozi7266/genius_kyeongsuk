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
	<form method="post" action="${pageContext.request.contextPath}/board/write"
		  enctype="multipart/form-data"
	>
	<div>
		<label>제목</label>
		<input type="text" name="title" />			
	</div>
	<div>
		<label>글쓴이</label>
		<input type="text" name="writer" />			
	</div>
	<div>
		<label>내용</label>
		<input type="text" name="content" />			
	</div>
	<div>
		<label>파일첨부</label>
		<input type="file" name="attach" />			
	</div>
	<div>
		<button>등록</button>			
	</div>
	
	</form>

</body>
</html>












