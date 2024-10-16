<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 상세</title>
</head>
<body>
	<h2>게시글 상세</h2>
	<div>게시글 번호: ${board.no}</div>
	<div>제목 : ${board.title}</div>
	<div>작성자 : ${board.writer}</div>
	<div>내용 : ${board.content}</div>
	<div>조회수 : ${board.viewCnt}</div>
	<div>등록일 : ${board.regDate}</div>

	<div>
		<form action="${pageContext.request.contextPath}/board/delete"
			method="post">
			<input type="hidden" name="no" value="${board.no}" />
			<button type="submit">삭제</button>
		</form>

	</div>

	<div>
		<a href="${pageContext.request.contextPath}/board/list">목록으로 돌아가기</a>
	</div>
</body>
</html>
