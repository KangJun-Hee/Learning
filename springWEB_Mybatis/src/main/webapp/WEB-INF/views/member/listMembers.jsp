<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
	request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<meta charset=UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>
	<table border="1" align="center">
		<tr align="center" bgcolor="lightgreen">
			<td><b>아이디</b></td>
			<td><b>비밀번호</b></td>
			<td><b>이름</b></td>
			<td><b>이메일</b></td>
			<td><b>가입일</b></td>
			<td><b>삭제</b></td>
			<td><b>수정</b></td>
		</tr>

		<c:forEach var="member" items="${membersList}">
			<tr align="center">
				<td>${member.id}</td>
				<td>${member.pwd}</td>
				<td>${member.name}</td>
				<td>${member.email}</td>
				<td>${member.joinDate}</td>
				<td><a
					href="${contextPath}/member/removeMember?id=${member.id }">삭제</a></td>
				<td><a
					href="${contextPath}/member/updateMember?id=${member.id }">수정</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="${contextPath}/member/joinForm"><h1	style="text-align: center">회원가입</h1></a>
	<a href="${contextPath}/member/loginForm"><h1 style="text-align: center">로그인</h1></a>


	<h1 style="text-align: center">로그아웃 과 수정은 과제입니다.</h1>


</body>
</html>