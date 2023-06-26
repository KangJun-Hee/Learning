<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>06_managerMain.jsp</title>
</head>
<body>
	<%
	String id = (String) session.getAttribute("managerId");

	if (id == null) {
		response.sendRedirect("00_shopMain.jsp");
	}
	%>
	<%
	if (id != null) {
	%>
	<a href="07_logout.jsp">로그아웃</a>
	<table border="1">
		<tr>
			<th>상품관련 작업</th>
		</tr>
		<tr>
			<td><a href="08_bookRegisterForm.jsp">상품등록</a></td>
		</tr>
		<tr>
			<td><a href="10_bookList.jsp?book_kind=all">상품수정/삭제</a></td>
		</tr>
		<tr>
			<th>구매된 상품관련 작업</th>
		</tr>
		<tr>
			<td><a href="15_orderedList.jsp">전체구매목록 확인</a></td>
		</tr>
	</table>
	<%
	}
	%>
</body>
</html>