<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>log out</title>
</head>
<body>
	<%
		session.invalidate();
		response.sendRedirect("01_main.jsp");//페이지 이동 데이터X
	%>
</body>
</html>