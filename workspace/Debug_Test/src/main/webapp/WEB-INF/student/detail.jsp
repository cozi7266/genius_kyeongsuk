<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>학생 상세 정보</title>
</head>
<body>
    <h2>학생 상세 정보</h2>
    <table border="1">
        <tr>
            <th>학생 ID</th>
            <td>${student.student_id }</td>
        </tr>
        <tr>
            <th>이름</th>
            <td>${student.getName }</td>
        </tr>
        <tr>
            <th>학과</th>
            <td>${student.department }</td>
        </tr>
        <tr>
            <th>이메일</th>
            <td>${student.email }</td>
        </tr>
        <tr>
            <th>전화번호</th>
            <td>${student.phone_number }</td>
        </tr>
    </table>
    
    <a href="student?action=updateform&name=${student.studentId}">수정</a>
    <a href="student?action=remove">삭제</a>
    <a href="student?doList()">목록</a>
</body>
</html>