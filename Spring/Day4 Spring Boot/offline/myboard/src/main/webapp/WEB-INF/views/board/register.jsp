<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>글 등록</title>
</head>
<body>
    <h2>글 등록</h2>

    <form action="board/register" method="post">
        <table>
            <tr>
                <td>제목:</td>
                <td><input type="text" name="title" required /></td>
            </tr>
            <tr>
                <td>작성자:</td>
                <td><input type="text" name="writer" required /></td>
            </tr>
            <tr>
                <td>내용:</td>
                <td><textarea name="content" rows="5" cols="30" required></textarea></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center;">
                    <input type="submit" value="등록" />
                    <input type="reset" value="초기화" />
                </td>
            </tr>
        </table>
    </form>

</body>
</html>
