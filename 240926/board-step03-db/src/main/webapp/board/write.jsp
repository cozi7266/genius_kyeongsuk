<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>대전 4반 게시판</h2>
	<!-- 작성자, 제목, 번호, 조회수 -->
	<form action="${pageContext.request.contextPath}/board" method="post">
		<input type="hidden" name="action" value="write" />
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" /></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer" /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="8" cols="80" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<button>등록</button>
				</td>
			</tr>
		</table>	
	</form>
</body>
</html>






