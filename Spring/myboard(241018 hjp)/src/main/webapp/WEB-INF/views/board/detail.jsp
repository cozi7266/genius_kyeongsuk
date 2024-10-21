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
	
	<div>
		<label>제목</label>
		<span>${board.title}</span>
	</div>
	<div>
		<label>작성자</label>
		<span>${board.writer}</span>
	</div>
	<div>
		<label>내용</label>
		<span>${board.content}</span>
	</div>
	<div>
		<label>조회수</label>
		<span>${board.viewCnt}</span>
	</div>
	<div>	
		<label>등록일</label>
		<span>${board.regDate}</span>
	</div>
	<div>	
		<label>첨부파일</label>
		<img src="/img${board.boardFile.filePath}/${board.boardFile.systemName}"/>
		<span><a href="/img${board.boardFile.filePath}/${board.boardFile.systemName}">${board.boardFile.oriName}</a></span>
		<span><a href="/board/download?filePath=${board.boardFile.filePath}&systemName=${board.boardFile.systemName}">파일다운로드</a></span>
	</div>
	

</body>
</html>