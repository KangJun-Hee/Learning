<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>12</title>
</head>
<body>
<%
	int onePageArticlesCount = Integer.parseInt(request.getParameter("onePageArticlesCount"));
	session.setAttribute("onePageArticlesCount",onePageArticlesCount);
	response.sendRedirect("_04boardList.jsp");
%>
</body>
</html>