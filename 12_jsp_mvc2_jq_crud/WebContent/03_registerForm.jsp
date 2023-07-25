<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script src="03_register.js"></script>

<table border="1">
	<tr>
		<td>아이디</td>
		<td><input type="email" id="id" name="id"></td>
		<td><button id="checkId">ID중복확인</button></td>
	</tr>
	<tr>
		<td>패스워드</td>
		<td colspan="2"><input type="password" id="passwd" name="passwd"></td>
	</tr>
	<tr>
		<td>패스워드 재입력</td>
		<td colspan="2"><input type="password" id="repass" name="repass"></td>
	</tr>
	<tr>
		<td>이름</td>
		<td colspan="2"><input type="text" id="name" name="name"></td>
	</tr>
	<tr>
		<td>주소</td>
		<td colspan="2"><input type="text" id="address" name="address"></td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td colspan="2"><input type="tel" id="tel" name="tel"></td>
	</tr>
	<tr>
		<td colspan="3">
			<button id="process">가입하기</button>
			<button id="cancle">취소</button>
		</td>
	</tr>
</table>
