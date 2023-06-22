<%@page import="com.rentcar.Rentcar"%>
<%@page import="com.rentcar.RentcarDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일명: 10_carReserveInfo.jsp </title>
</head>
<body>
	<!-- 자동차 사진을 클릭하면  10파일로 넘어온다. 
		내가 클릭한 사진의 즉 차량 번호를 가지고 와서 DAO 그 렌트카 객체를 찾아서
		이미지와 같이 출력을 해준다. 
		
		메서드 getOneCar(no)
	
	  -->
	
	<%
		int no = Integer.parseInt(request.getParameter("no"));
	
		// 렌트카 하나에 대한 정보를 얻어옴/
		Rentcar bean = RentcarDAO.instance.getOneCar(no);
		
		int category = bean.getCategory();
		String temp = "";
		
		if(category == 1) temp ="소형";
		else if(category == 2) temp ="중형";
		else if(category == 3) temp ="대형";
	%>
	<div align = "center">
	
		<form action="01_main.jsp?center=11_carOptionSelect.jsp" method="post">
			
			<table>
				<tr height ="100">
				
					<td align ="center" colspan="3" >
						<font size="6" color ="gray">
							<%=bean.getName()%> 차량 선택
						</font>
					</td>					
				</tr>
				
				<tr>
					<td rowspan="6" width="500" align="center">
						<img alt="" src="imgCar/<%=bean.getImg() %>" width="450" >
					</td>			
					<td width ="250" align ="center"> 차량이름 </td>
					<td width ="250" align ="center"> <%=bean.getName() %> </td>
					
				</tr>
				
				<!--  1대 2대 선택하는 옵션  -->
				<tr>
					<td width ="250" align ="center"> 차량수량  </td>
				
					<td width ="250" align ="center"> 
						<select name ="qty">
							<option value ="1">1</option>
							<option value ="2">2</option>
							<option value ="3">3</option>						
						</select>						
					</td>					
				</tr>
				<tr>
				<!--  차량 분류 -->
					<td width ="250" align ="center"> 차량분류  </td>
					<td width ="250" align ="center"> <%=temp %> </td>
				</tr>
				
				<tr>
				<!--  차량 대여 가격 -->
					<td width ="250" align ="center"> 대여가격  </td>
					<td width ="250" align ="center"> <%=bean.getPrice() %> </td>
				</tr>
				
				<tr>
				<!--  차량 제조회사 -->
					<td width ="250" align ="center"> 제조회사  </td>
					<td width ="250" align ="center"> <%=bean.getCompany() %> </td>
				</tr>			
				
				<tr>
					<td width="250" align="center">
						<input type="hidden" name="no" value="<%=bean.getNo() %>" />
						<input type="hidden" name="img" value="<%=bean.getImg() %>" />
						<input type="submit" value="옵션선택후 구매하기" />
					
					</td>
				</tr>						
			</table>
			
			<br />
			<br />
			<br />
			<font size="5" color ="gray">차량 정보 보기 </font>
			<p> <%= bean.getInfo() %></p>							
		</form>	
	</div>  
	  
</body>
</html>