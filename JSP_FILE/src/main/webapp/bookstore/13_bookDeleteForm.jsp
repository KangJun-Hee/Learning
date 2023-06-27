<%-- 10_bookDeleteForm.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<%
	String managerId = (String)session.getAttribute("managerId");
	if(managerId == null){
		response.sendRedirect("00_shopMain.jsp");
	}else{
		int book_id = Integer.parseInt(request.getParameter("book_id"));
		String book_kind = request.getParameter("book_kind");
%>

<!DOCTYPE html>
<html lang="ko">
	<head>
	<meta charset="UTF-8">
	<title>관리자 책 삭제</title>
	</head>
	<body>
		<p>책 삭제</p>
		<br>
		
		<form method="post" action="14_bookDeletePro.jsp?book_id=<%= book_id %>
		&book_kind=<%= book_kind %>">
			<table border="1">
				<tr>
					<td align="right">
						<a href="06_managerMain.jsp">관리자 메인으로</a>&nbsp;
						<a href="10_bookList.jsp?book_kind=<%= book_kind %>">목록으로</a>						
					</td>
				</tr>
				<tr height="30">
					<td align="center">
						<input type="submit" value="삭제">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
<% } %>