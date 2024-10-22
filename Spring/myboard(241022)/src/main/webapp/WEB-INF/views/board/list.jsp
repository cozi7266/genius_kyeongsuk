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
	<select id="listSize" onchange="movePage(this.value)">
		<option value="5" <c:if test="${param.listSize == 5}">selected</c:if>>5</option>
		<option value="10" <c:if test="${param.listSize == 10}">selected</c:if>>10</option>
		<option value="20" <c:if test="${param.listSize == 20}">selected</c:if>>20</option>
		<option value="50" <c:if test="${param.listSize == 50}">selected</c:if>>50</option>
	</select>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>조회수</th>
			<th>등록일</th>
		</tr>		
		<c:forEach var="board" items="${list}">
		<tr>
			<td>${board.no}</td>
			<td><a href="detail?no=${board.no}">${board.title}</a></td>
			<td>${board.writer}</td>
			<td>${board.viewCnt}</td>
			<td>${board.regDate}</td>
		</tr>
		</c:forEach>
	</table>
	<div>
		<a href="${pageContext.request.contextPath}/board/write">글쓰기</a>
	</div>
	
	<!--  paging 영역 설정 -->
	<div>
		<c:if test="${pr.prev}">
			<a href="list?page=1">[첫페이지]</a>
			<a href="list?page=${pr.beginPage - 1}">[이전]</a>
		</c:if>
		<c:forEach var="i" begin="${pr.beginPage}" end="${pr.endPage}">
			<a href="list?page=${i}">[${i}]</a>
		</c:forEach>
		<c:if test="${pr.next}">
			<a href="list?page=${pr.endPage + 1}">[다음]</a>
			<a href="list?page=${pr.lastPage}">[마지막페이지]</a>
		</c:if>
	</div>
	
	<script>
		function movePage(listSize) {
			location.href  = "list?listSize=" + listSize;
		}
	</script>
</body>
</html>












