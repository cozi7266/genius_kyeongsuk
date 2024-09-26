<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title></title>
<style>
	.board-detail > div {
		display: inline-block;
	}
</style>
</head>
<body>
	<h2>게시판 상세</h2>
	<div class="board-detail">
		<label>번호</label>
		<div>${board.no}</div>
	</div>
	<div class="board-detail">
		<label>제목</label>
		<div>${board.title}</div>
	</div>
	<div class="board-detail">
		<label>작성자</label>
		<div>${board.writer}</div>
	</div>
	<div class="board-detail">
		<label>내용</label>
		<div>${board.content}</div>
	</div>
	<div class="board-detail">
		<label>조회수</label>
		<div>${board.viewCnt}</div>
	</div>
	<div class="board-detail">
		<a href="${pageContext.request.contextPath}/board?action=delete&no=${board.no}">삭제</a>
		<a>수정</a>
		<a href="${pageContext.request.contextPath}/board?action=list">목록</a>
	</div>
</body>
</html>










