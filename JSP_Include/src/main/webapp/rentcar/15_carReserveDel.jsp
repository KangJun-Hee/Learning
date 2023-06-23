<%@page import="com.rentcar.RentcarDAO"%>
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
		//예약삭제 메서드 호출
		String id = (String)session.getAttribute("id");
		String rday = (String)session.getAttribute("rday");
		
		RentcarDAO.instance.carRemoveReserve(id,rday);
		response.sendRedirect("01_main.jsp");
	%>
</body>
</html>