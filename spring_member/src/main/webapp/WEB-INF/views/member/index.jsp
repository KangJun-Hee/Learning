<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
</head>
<body>
	<h1>스프링 CRUD</h1>
	<a href="${cp}/member/userMenu">사용자 메뉴</a><br/>
	<a href="${cp}/member/list">관리자 메뉴</a><br/>
</body>
</html>
<!-- 
<%--
CREATE DATABASE springMemberDB;
USE springMemberDB;

CREATE TABLE member(
	num INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	id VARCHAR(20),
    pw VARCHAR(20),
    email VARCHAR(20)
);

delete from member where num=3;
drop table member;
SELECT * FROM member;

SELECT * FROM member ORDER BY num ASC;


INSERT INTO member (id, pw, email) VALUES('qwer', '1234', 'qwer@naver.com');
--%>

 -->