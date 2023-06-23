<%@page import="com.rentcar.RentcarDAO"%>
<%@page import="com.rentcar.Rentcar"%>
<%@page import="java.util.ArrayList"%>
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
	// 데이터베이스에 연결하여 최신순 자동차 3개만 뿌려주는 데이터를 가져옴 
	ArrayList<Rentcar> list = RentcarDAO.instance.getSelectCar3();
	%>
	<div align="center">
		<table>
			<tr height="60">
				<td align="center" colspan="3"><font size="6" color="gray">최신형
						자동차</font></td>
			</tr>
			<tr height="240">
			
				<%
					for(int i = 0; i <list.size(); i++){
						Rentcar bean = list.get(i);
					
				%>
				<td width ="333" align="center">
					<a href ="01_main.jsp?center=10_carReserveInfo.jsp?no=<%=bean.getNo()%>">
					
						<img alt="" src="imgCar/<%= bean.getImg()%>"
							width="300" height ="220">					
					
					</a>
					<p>차량명 : <%= bean.getName() %></p>
				</td>			
				<%} %>
			</tr>	
		
		</table>

		<!-- ================================================== -->

		<hr size="3" color="red">
		<p>
			<font size="4" color="gray"><b>차량 검색 하기</b></font>
		<form action="01_main.jsp?center=13_carCategoryList.jsp" method="post">
			<font size="3" color="gray"><b>차량 검색 하기</b></font>&nbsp;&nbsp; <select
				name="category">
				<option value="1">소형</option>
				<option value="2">중형</option>
				<option value="3">대형</option>
			</select> <input type="submit" value="검색" />&nbsp;&nbsp;
		</form>

		<!--  전체 검색을 눌렀을 때  -->
		<button
			onclick="location.href ='01_main.jsp?center=09_carAllList.jsp'">
			전체 검색</button>

	</div>
</body>
</html>


