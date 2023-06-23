<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 렌트카 보기</title>
</head>
<body>
	<div align="center">
		<table>
			<tr height="60">
				<td align="center" colspan="3">
					<font size="6" color="gray">
						전체렌트카 보기
					</font>
				</td>
			</tr>
			
			<%
				ArrayList<Rentcar> v = RentcarDAO.instance.getAllCar();
				
				int j = 0;
				for(int i=0; i<v.size(); i++){
					if(j%3 == 0){
			%>
			<tr height="220">
				  <%} %>
				<td width="333" align="center">
					<a href="01_main.jsp?center=10_carReserveInfo.jsp?no=<%=v.get(i).getNo();%>">
						<img alt="" src="imgCar/<%=v.get(i).getImg()%>"
							width="300" height="200">
					</a>		
					<p>
						<font size="3" color="gray">
							차량명 | <%=v.get(i).getName() %>
						</font>					
					</p>		
				</td>
			</tr>
		</table>




	</div>
</body>
</html>

















