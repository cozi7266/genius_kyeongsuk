<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>로그인</h2>
	<form action="${pageContext.request.contextPath}/member" method="post">
		<input type="hidden" name="action" value="login" />
		<div>
			<input type="text" name="id" placeholder="아이디 입력" />
		</div>		
		<div>
			<input type="password" name="password" placeholder="비밀번호 입력" />
		</div>
		<div>
			<button>로그인</button>
		</div>		
	</form>
</body>
</html>







