<%@page import="java.util.ArrayList"%>
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
	<!-- jstl(jsp standard tab library)
		연산,조건문,반복문을 편히 처리가능하게 jsp내에서
		자바코드 안 쓰고 문장(로직)을 구현할 수 있도록 해 준다.
		
		커스텀태그
		1)jstl
			:jsp에서 가장많이 사용하는 기능을 태그로 제공
			 따로 라이브러리 추가해서 사용
		2)개발자가 만든 커스텀태그
			:스프링프레임워크에서 미리 만들어 제공(오픈소스)
			
		라이브러리
			core:변수,조건문,반복문처리
			국제화(fmt):숫자,날짜형식...
			데이터베이스(sql):sql처리하는 태그
			함수(functions):컬렉션처리,String처리
			xml:흐름제어 
		-->
	
	<%
		int age = 20;
		String name1 = "홍길동";
		String name2 = "이순신";
		
		ArrayList<String> list = new ArrayList<>();
	%>
	숫자:<c:if test="${0 ne age}"></c:if><br>
	문자:<c:if test="${name1 ne name2}"></c:if><br>
	null:<c:if test="${null ne list}"></c:if><br>
	
	객체의 값이 비어있을 때:<c:if test="${empty list}"></c:if><br>
	객체의 값이 있을 때:<c:if test="${!empty list}"></c:if><br>
	
	<!-- 삼항 연산자 -->
	${(5>3) ? 5:3}
	
</body>
</html>












