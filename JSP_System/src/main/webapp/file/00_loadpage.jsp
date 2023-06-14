<%@page import="_05_User.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>00_loadpage</title>
</head>
<body>
	<%
	//메모장 파일이 저장될 위치를 저장한다.
	UserDAO temp = new UserDAO();
	temp.realpath = application.getRealPath("/");
	//파일이 존재하면 해당 파일을 불러 온다.
	temp.loadData();
	//파일을 로딩 후 바로 메인페이지로 강제이동 시킨다.
	response.sendRedirect("01_index.jsp");
	%>
</body>
</html>