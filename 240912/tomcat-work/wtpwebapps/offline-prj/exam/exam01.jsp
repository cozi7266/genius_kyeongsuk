<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연습1</title>
</head>
<body>
  <h2>JSP 연습하기</h2>
  <!-- 컨텐츠 주석문 -->
  <%-- JSP 주석문 ; .jsp -> .java 변환시 주석 처리되어 포함되지 않는다.--%>
  <%! %> <%-- 선언문 : 멤버변수 또는 메서드를 선언시 사용 --%> 
  <%@ %> <%-- 지시문 : page, include, taglib --%>
  <%= %> <%-- 표현식 : 출력시 사용, System.out.println --%>
  <% %>  <%-- 실행문 : 자바코드 작성 --%>
</body>
</html>