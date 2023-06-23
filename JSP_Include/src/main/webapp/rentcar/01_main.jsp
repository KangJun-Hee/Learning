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

	<div align="center">
		<%
		// DAO클래스에서 초기 설정 내용 호출하기
		RentcarDAO.instance.realpath = application.getRealPath("");
		RentcarDAO.instance.memberBasicSet();
		RentcarDAO.instance.rentcarBasicSet();

		// url 에 오는 변수값을 꺼내는 거! 
		String center = request.getParameter("center");

		// 처음 실행시에는 center 값이 넘어오지 않기 때문에 
		// null 처리 해준다. 

		if (center == null) {
			center = "04_center.jsp"; // 기본값설정해서 메인화면을 출력 
		}
		%>


		<table>
			<!-- top 부분  -->
			<tr>
				<td><jsp:include page="02_top.jsp" /></td>
			</tr>
			<!-- center 부분 -->
			<tr>
				<td><jsp:include page="<%=center%>" /></td>
			</tr>

			<!-- bottom 부분 -->
			<tr>
				<td><jsp:include page="03_bottom.jsp" /></td>
			</tr>
		</table>

	</div>
</body>
</html>