<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 변수를 다룰 떄 set
	 	jsp의 로컬변수가 아니라 서블릿보관소에 4가지영역 있음
	 	그곳에 내가 범위를 설정해 저장~
	 
	 scope의 기본값은 page
	 -->
	<c:set var="username1" value="이서희" />
	<c:set var="username2">박지성</c:set>
	${username1}
	<br> ${username2}
	<br> ${pageScope.username1}
	<br> ${pageScope.username2}
	<br>

	<!-- jspContext에 저장한다 -->
	<c:set var="data2" value="${10}" />
	<br> data2 =
	<c:out value="${data2}"></c:out>
	<br>

	<!-- 변수삭제 후 출력 -->
	<c:remove var="data2" />
	<br> data2 =
	<c:out value="${data2}"></c:out>
	<br>

	<h3>JSTL core 태그 - if</h3>
	<c:set var="country" value="${'korea'}" />
	<c:if test="${country ne null}">
	 	국가명:<c:out value="${country}" />
		<br>
	</c:if>
	<c:out value="${country}" />
	의 겨울은 춥습니다~!
	<br>

<br>
	<!-- test 조건식작성한다 맞으면 true,내용이 실행된다~ -->
	<c:if test="${10>20}" var="result1">
	 	10은 20보다 크다.<br>
	</c:if>
	result1 = ${result1}
	<br>

	<br>
	<c:if test="${10<20}" var="result2">
	 	20은 10보다 크다.<br>
	</c:if>
	result2 = ${result2}
	<br>
</body>
</html>















