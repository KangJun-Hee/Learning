<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>member테이블의 레코드 삭제</h2>

	<form method="post" action="03_10_deletePro.jsp">
		아이디: <input type="text" name="id" maxlength="50"><br>
		<br> 패스워드: <input type="password" name="passwd" maxlength="16"><br>
		<br> <input type="submit" value="입력완료">
	</form>
</body>
</html>