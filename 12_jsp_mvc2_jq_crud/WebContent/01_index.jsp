<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="jquery/jquery-1.11.0.min.js"></script>
<body>
	<img src="mollahalf.png"/>
	<div id="main_auth">
		<jsp:include page="02_loginForm.jsp"/>
	</div>
</body>

<%-- 
==================================================================================
CREATE DATABASE mvc2_jq_crud;
USE mvc2_jq_crud;

CREATE TABLE member(
	id VARCHAR(20),
    passwd VARCHAR(20),
    name VARCHAR(20),
    reg_date DATETIME,
    address VARCHAR(100),
    tel VARCHAR(20)
);

SELECT * FROM member;
==================================================================================
			
--%>