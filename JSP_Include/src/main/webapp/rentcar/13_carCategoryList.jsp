<%@page import="com.rentcar.Rentcar"%>
<%@page import="com.rentcar.RentcarDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>13_carCategoryList</title>
</head>
<body>
	<%
	//카테고리 분류값 받아온다(int로)
	int category = Integer.parseInt(request.getParameter("category"));
	
	String temp = "";//데이터저장할곳
	
	if(category == 1){
		temp = "소형";
	} else if(category == 2){
		temp="중형";
	} else if(category == 3){
		temp="대형";
	}
	%>
	
	<div align = "center">
		<table>
			<tr height="60">
				<td align="center" colspan="3">
					<font size="6" color="gray">
						<%=temp%>자동차
					</font>
				</td>
			</tr>
			<%
			 ArrayList<Rentcar> list = RentcarDAO.instance.getCategoryCar(category);
			 //tr을 3개씩 보여 주고 다시 tr을 실행할 수 있도록하는 변수선언
			 int j=0;
			 
			 for(int i=0; i<list.size(); i++){
				 Rentcar bean = list.get(i);
				 
				 //나머지값 0이면
				 if(j % 3 == 0){		
			%>
			<tr height="220">
				<%} %>
				<td width="333" align="center">
					<a href="01_main.jsp?center=10_carReserveInfo.jsp?no=<%=bean.getNo()%>">
						<img alt="" src="imgCar/<%=bean.getImg()%>" width="300" height="200">
					</a>
					<p>
						<font size=3 color="gray">
							<b>차량명 | <%=bean.getName()%></b>
						</font>
					</p>
				</td>
				<%
					//j값을 증가해 하나의 행에 총 3개의 차량정보 보여 주기 위해 증가
					j += 1;
			 	}
				%>
			</tr>
		</table>
	</div>
</body>
</html>























