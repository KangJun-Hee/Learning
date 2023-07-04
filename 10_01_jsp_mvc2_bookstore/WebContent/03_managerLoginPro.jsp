<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>관리자 로그인</title>
	</head>
	<body>
		
		<c:if test="${ check == 1 }">
			<script type="text/javascript">
				alert('로그인 성공!');
				location.href='/10_01_jsp_mvc2_bookstore/mg/main.do';
			</script>
		</c:if>
		
		<c:if test="${ check != 1 }">
			<script type="text/javascript">
				alert('아이디와 패스워드를 확인해주세요!');
			 	history.go(-1); 
			</script>
		</c:if>
	</body>
</html>