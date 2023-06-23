<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String hakbun = (String)session.getAttribute("hakbun");
	if(hakbun == null){
		response.sendRedirect("00_login.jsp");
	}else{
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강신청 메인</title>
</head>
<body>
	<%
	String center = request.getParameter("center");
	if (center == null) {
		center = "04_center.jsp";
	}
	%>
	<table>
		<tr align="center" height="200">
			<!--  왼쪽 left.jsp -->

			<td align = "center" width ="200" rowspan="2">
				<jsp:include page="03_left.jsp"></jsp:include>
			</td>
			<!-- top.jsp   -->
			<td align = "center" height="800">
				<jsp:include page="02_top.jsp"></jsp:include>
			</td>
		</tr>

		<tr height="200">
			<!--  중앙 center -->
			<td align = "center" height="800">
				<jsp:include page="<%=center %>"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>
<%
	}
%>













