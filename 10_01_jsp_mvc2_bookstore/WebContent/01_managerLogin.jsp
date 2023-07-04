<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="UTF-8">

<c:if test="${ empty sessionScope.mngId }">
	<form method="post" action="/10_01_jsp_mvc2_bookstore/mg/loginPro.do">
		<table border="1">
			<tr>
				<td>
					아이디 <input type="email" name="id" size="20" maxlength="50" 
					placeholder="example@shop.com"> 
					&nbsp;&nbsp;
					 패스워드 <input type="password" name="passwd" size="20" maxlength="16">
					&nbsp;&nbsp; 
					<input type="submit" value="로그인">
				</td>
			</tr>
		</table>
	</form>
</c:if>

<c:if test="${ !empty sessionScope.mngId }">
	<form method="post" action="/10_01_jsp_mvc2_bookstore/mg/logout.do">
		관리자 로그인 성공! 작업중... <input type="submit" value="로그아웃">
	</form>
</c:if>