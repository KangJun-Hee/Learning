<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		session.invalidate();
	%>
	<script>
		alert("로그아웃 됐습니닷닷닷다 닷다라닷닷닷");
		location.href="00_login.jsp";
	</script>
</body>
</html>