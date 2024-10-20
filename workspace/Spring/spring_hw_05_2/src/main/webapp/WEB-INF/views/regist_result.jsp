<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 등록 결과</title>
</head>
<body>
	<h1>사용자 등록 결과</h1>
	<h2>등록 사용자 결과</h2>

	<table border="1">
		<tr>
			<th>항목</th>
			<th>내용</th>
			<th>이미지</th>
		</tr>
		<tr>
			<td>아이디</td>
			<td>${user.id}</td> 
			<td rowspan="5"><c:choose>
					<c:when test="${not empty user.img}">
						<img
							src="/upload/${user.img}"
							alt="사용자 이미지" width="100" height="100" />
					</c:when>
					<c:otherwise>
						<p>이미지가 없습니다</p>
					</c:otherwise>
				</c:choose></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>${user.password}</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${user.name}</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>${user.email}</td>
		</tr>
		<tr>
			<td>나이</td>
			<td>${user.age}</td>
		</tr>
	</table>

	<br />
	<a href="/regist">추가 등록</a>
	<a href="/list">사용자 목록</a>
</body>
</html>
