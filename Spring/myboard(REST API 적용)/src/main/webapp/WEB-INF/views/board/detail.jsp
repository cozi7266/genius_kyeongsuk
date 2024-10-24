<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title></title>
</head>
<body>
	<h2>게시글 정보</h2>
	<div>
		<label>제목</label>
		<span>${board.title}</span>
	</div>
	<div>
		<label>내용</label>
		<span>${board.content}</span>
	</div>
	<div>
		<label>작성자</label>
		<span>${board.writer}</span>
	</div>
	<div>
		<label>조회수</label>
		<span>${board.viewCnt}</span>
	</div>
	<div>
		<label>첨부파일</label>
		<div>
			${board.boardFile.oriName}
		</div>
	</div>
	<a href="list">목록</a>
</body>
</html>












