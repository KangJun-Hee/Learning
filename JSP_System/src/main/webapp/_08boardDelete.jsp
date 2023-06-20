<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>08</title>
</head>
<body>

<%
	int num = Integer.parseInt(request.getParameter("num"));
%>
	<div align="center">
		<h2>게시글 삭제하기</h2>
		<form method="post" action="_09boardDeletePro.jsp">
			<table border="1">
				<tr>
					<td>비밀번호 입력</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="hidden" name="num"
						value="<%=num%>"> <input type="submit" value="삭제하기">
						<input type="button" value="목록으로"
						onclick="window.location.href='_04boardList.jsp'"></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>