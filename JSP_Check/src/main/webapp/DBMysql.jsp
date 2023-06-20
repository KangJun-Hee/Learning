<%@page import="java.sql.Connection"%>
<%@page import="db.DBUtil"%>
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
		Connection conn = DBUtil.getMysqlConnection();
		out.println("연결 성공 :" + conn +"<br/>");
		DBUtil.close(conn);
	
	%>

</body>
</html>