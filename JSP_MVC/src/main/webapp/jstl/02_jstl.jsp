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
	반복작업을 할 때 사용한다!
	var1 = "변수명" items="목록데이터"
	컬렉션 List, Set, Map, 배열, 콤마(,) 구분자로 나열된 문자열
	var1:반복문 돌면서 items에서 꺼낸 항목값을 가리키는 참조변수이다!
	
	<h3>문제1 1~10출력</h3>
	<c:forEach var="i" begin="1" end="10">
		${i} &nbsp;
	</c:forEach>
	<br>
	
	<h3>문제2 1~10 홀수 출력</h3>
	<c:forEach var="i" begin="1" end="10">
		<c:if test="${i%2==1}">
			${i} &nbsp;
		</c:if>
	</c:forEach>
	<br>
	
	<h3>문제2 1~10 합 출력</h3>
	<c:forEach var="i" begin="1" end="10">
		<c:set var="sum" value="${sum=sum+i}"/>
	</c:forEach>
	${sum}
	<br>
	
	<h3>문제2 1~100 홀수의 개수 출력</h3>
	
	<br>
	
	<h3>문제2 구구단 출력 2단! 된다.</h3>
	<c:forEach var="i" begin="1" end="10">
		<c:if test="${i%2==1}">
			${i} &nbsp;
		</c:if>
	</c:forEach>
	<br>
	
</body>
</html>










