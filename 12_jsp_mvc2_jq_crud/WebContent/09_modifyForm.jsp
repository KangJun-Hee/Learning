<%@page import="member.Member"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="jquery/jquery-1.11.0.min.js"></script>
<script src="08_modify.js"></script>

<% request.setCharacterEncoding("utf-8");%>

<% 
  String id = (String)session.getAttribute("id");
  String passwd = request.getParameter("passwd");

  MemberDAO manager = MemberDAO.getInstance();
  //아이디와 비밀번호에 해당하는 사용자의 정보를 얻어냄
  Member m = manager.getMember(id,passwd); 
    
  try{//얻어낸 사용자 정보를 화면에 표시
%>

<h2>회원정보 수정</h2>
<table border="1">
	<tr>
		<td>아이디</td>
		<td><input type="email" id="id" name="id" value="<%= id %>" readonly disabled></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" id="passwd" name="passwd"></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input type="text" id="name" name="name" value="<%= m.getName() %>"></td>
	</tr>
	<tr>
		<td>주소</td>
		<td><input type="text" id="address" name="address" value="<%= m.getAddress() %>"></td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td><input type="tel" id="tel" name="tel" value="<%= m.getTel() %>"></td>
	</tr>
	<tr>
		<td colspan="2">
			<button id="modifyProcess">수정</button>
			<button id="cancle">취소</button>
		</td>
	</tr>
</table>
<%}catch(Exception e){}%>