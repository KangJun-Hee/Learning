<%@page import="com.rentcar.RentcarDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>01_main</title>
</head>
<body>
	<div align="center">
	<%
		//DAO클래스에서 초기설정 내용 호출하기
		RentcarDAO.instance.realpath = application.getRealPath("");
		RentcarDAO.instance.memberBasicSet();
		RentcarDAO.instance.rentcarBasicSet();
		
		//url에 오는 변수값을 꺼내는 거!
		String center = request.getParameter("center");
		
		//처음 실행시엔 center값이 넘어오지 않기에 null처리
		if(center == null){
			center = "04_center.jsp";//기본값설정해 메인화면 출력
		}
	%>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
	<table>
		<!-- top -->
		<tr>
			<td><jsp:include page="02_top.jsp" /></td>
		</tr>

		<!-- center -->
		<tr>
				<jsp:include page="<%=center%>"/>
		</tr>

		<!-- bottom -->
		<tr>
			<td><jsp:include page="03_bottom.jsp" /></td>
		</tr>
	</table>
	</div>
</body>
</html>