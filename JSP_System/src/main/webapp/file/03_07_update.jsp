<%@page import="_05_User.UserDAO"%>
<%@page import="_05_User.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String log = (String)session.getAttribute("log");
		UserDTO user = UserDAO.getInstance().getUserId(log);
	%>
	<h3>회원 정보 </h3>
	<%=user.getId() %><br>
	<%=user.getName() %><br>
	<br>

	<form method="post" action="03_08_updatePro.jsp">

		패스워드: <input type="password" name="passwd" maxlength="16"><br>
		<br> 변경할 이름: <input type="text" name="name" maxlength="10"><br>
		<br> <input type="hidden" value=<%= user.getId() %> name="id">
		<input type="submit" value="입력완료">
	</form>
</body>
</html>