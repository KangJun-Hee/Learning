<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="jquery/jquery-1.11.0.min.js"></script>
<script src="02_login.js"></script>

<%
String id ="";
try{
	id = (String)session.getAttribute("id");
%>

<% if(id == null || id.equals("")){ %>
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="email" id="id" name="id" placeholder="example@kings.com"></td>
		</tr>
		<tr>
			<td>패스워드</td>
			<td><input type="password" id="passwd" name="passwd" placeholder="6~16자 숫자/문자"></td>
		</tr>
		<tr>
			<td colspan="2">
				<button id="login">로그인</button>
				<button id="register">회원가입</button>
			</td>
		</tr>
	</table>
<%}else{%>
	<table border="1">
		<tr>
			<td><b><%=id %></b>님이 로그인 하셨습니다.</td>
		</tr>
		<tr>
			<td>
				<button id="logout">로그아웃</button>
				<button id="update">회원 정보 변경</button>
			</td>
		</tr>
	</table>
<%}}catch(Exception e){e.printStackTrace();}%>
