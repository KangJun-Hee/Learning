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
	<div align="center">
		<c:if test="${ null ne id }">
				${ id }님, 환영합니다.<br>
			<br>
			<a href="logout.do">로그아웃</a>
			<br>
			<br>
			<a href="update.do">회원정보수정</a>
			<br>
			<br>
			<a href="delete.do">탈퇴</a>
			<br>
			<br>
		</c:if>

		<c:if test="${ null eq id }">
			<a href="join.do">회원가입</a>
			<br>
			<br>
			<a href="login.do">로그인</a>
		</c:if>
	</div>

	<hr>
	<br>
	<br>
	<br>

	<div align="center">
		<a href="apply.do">
			<img alt="입사지원하기" src="img/applyonline.png">
		</a>
	</div>
</body>
</html>
	<!--  jstl 이용해서 
		jsp페이지에서 로그인 안되면 기본 페이지를 보여주고 
		로그인이 되었다면 회원메인페이지로 이동하는 내용 
		단! 출력을 하실때 if문 비교해서 로그인이 안되면 
		
		if문을 이용해서 보여지는 부분만 선택해서 보여준다.
		
		
		
	CREATE DATABASE joinmvcdb04;

USE joinmvcdb04;

CREATE TABLE member(
    id VARCHAR(20),
    pw VARCHAR(20),
    name VARCHAR(20),
    tel VARCHAR(20),
    email VARCHAR(30),
    field VARCHAR(20),       -- 지원분야
    skill VARCHAR(20),       -- 기술능력
    major VARCHAR(20)        -- 전공분야
);

SELECT * FROM member;	
		
		
		
		
	 -->