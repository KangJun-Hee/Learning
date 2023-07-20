<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!-- isELIgnored="false"
    SP 페이지에서 표현 언어(EL)를 사용하기 위해서 
    -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="result" value="${param.result }" />
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>manager Login</title>
<c:choose>
	<c:when test="${result=='loginFailed' }">
		<script>
			window.onload = function() {
				alert("아이디나 비밀번호가 틀립니다.다시 로그인 하세요!");
			}
		</script>
	</c:when>
</c:choose>
</head>
<body>
	<form name="frmLogin" method="post"
		action="${contextPath}/member/loginPro">
		<table border="1" align="center">
			<tr align="center">
				<td>아이디</td>
				<td><input type="text" name="id" value="" size="20"></td>
				<td>비밀번호</td>
				<td><input type="password" name="pwd" value="" size="20">
				</td>
			</tr>
			<tr align="center">
			</tr>
			<tr align="center">
				<td colspan="2"><input type="submit" value="로그인"> <input
					type="reset" value="다시입력"></td>
			</tr>
		</table>
	</form>
</body>
</html>