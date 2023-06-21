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
		String center = request.getParameter("center");
		if(center == null || center.equals(""))
		{
			center = "04_center1.jsp";	
		}
	%>
	<h2>홈페이지</h2>
	<table border="1">
		<tr>
			<td colspan="2">
				<jsp:include page="01_top.jsp" />
			</td>
		</tr>
		<tr>
			<td>
				<jsp:include page="02_left.jsp" />
			</td>
			<td>
				<jsp:include page="<%= center %>" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<jsp:include page="03_bottom.jsp" />
			</td>
		</tr>
	</table>
</body>
</html>