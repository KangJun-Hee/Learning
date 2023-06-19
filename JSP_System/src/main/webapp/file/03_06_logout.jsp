<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
</head>
<body>
	<%
	// 특정 세션을 지정해서 삭제하기
		session.removeAttribute("log");
	
	// 모든 세션지우기 
		session.invalidate();
	
	%>
	
	<script>
		alert("로그아웃 되셨습니다!");
		location.href="03_01_userMain.jsp";
	
	</script>
	
	
	
	
	
</body>
</html>