<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  로그인 문제  -->
	<h3>로그인</h3>
	
	<c:set var="dbId" value="qwer" />
	<c:set var="dbPw" value="1234" />

	<form method="post" action="../Test03">
		아이디 : <input type="text" name="id"> <br>
		비밀번호 : <input type="password" name="pw"> <br>
		
		<input type="hidden" name="dbId" value="${ dbId }"> 
		<input type="hidden" name="dbPw" value="${ dbPw }">
		 
		<input type="submit" value="로그인">
	</form>
</body>
</html>