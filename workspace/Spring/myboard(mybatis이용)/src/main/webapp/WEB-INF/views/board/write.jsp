<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<body>
	<h2>게시글 등록</h2>
	<form action="${pageContext.request.contextPath}/board/write" method="post" enctype="multipart/form-data">
		<div>
			<label>제목</label>
			<input type="text" name="title"/>
		</div>
		<div>
			<label>작성자</label>
			<input type="text" name="writer"/>		
		</div>
		<div>
			<label>내용</label>
			<textarea rows="10" cols="20" name="content"></textarea>		
		</div>
		<div>
			<label>파일첨부</label>
			<input type="file" name="attach"/>		
		</div>
		<input type="submit" value="등록">
		<input type="reset" value="초기화">
	</form>
</body>
</html>