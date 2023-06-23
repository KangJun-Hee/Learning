<%@page import="com.rentcar.Rentcar"%>
<%@page import="com.rentcar.RentcarDAO"%>
<%@page import="com.rentcar.CarReserve"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>12_carReserveResult.jsp</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8"); // 한글 처리
	%>
	
	<!-- CarReserve 객체를 생성을한다.  -->
	<jsp:useBean id="rbean" class="com.rentcar.CarReserve">
		<jsp:setProperty name ="rbean" property ="*" />
	</jsp:useBean>
	
	<!--  로그인이 안되어있으면 로그인 후 예약이 가능합니다! 
		href="05파일로 넘긴다."
	 -->
	 
	 <%
	 	String id = (String)session.getAttribute("id");
	 	if(id == null){	 
	 %>
	 <script>
	 	alert("로그인 후 예약이 가능합니다!");
	 	location.href="01_main.jsp?center=05_memberLogin.jsp"
	 </script>
	 <%} %>	 
	 <!-- 날짜 비교  -->
	 <%
	 Date d1 = new Date();
	 Date d2 = new Date();
	 
	 // 포맷이용해서 저장하는 방식!
	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	 d1 = sdf.parse(rbean.getRday());
	 d2 = sdf.parse(sdf.format(d2));
	 
	 // 날짜비교하는 메서드를 이용 
	 int compare = d1.compareTo(d2);
	 
	 // 예약하려는 날짜가 현재 날짜보다 이전이라면 -1
	 // 예약하려는 날짜가 현재 날짜가 같다 0
	 // 예약하려는 날짜가 현재 날짜보다 이후 라면 1리턴 
	 
	 if(compare < 0){
		 // 오늘 보다 이전 날짜를 선택했으니 예외적 상황이다 고객에 알려준다.
	 %>
	 <script>
	 	alert("현재 시스템 날짜보다 이전 날짜는 선택할 수 없습니다!");
	 	history.go(-1);
	 	 
	 </script>
	 <%} 
	 
	 // 결과적으로 아무런 문제가 없다면 데이터를 저장 후 결과를 페이지에 보여주기 
	 // 아이디값이 빈 클래스에 없기에 
	 String id1 = (String)session.getAttribute("id");
	 rbean.setId(id1);
	 
	 // 데이터베이스에 빈 클래스 저장 
	 RentcarDAO.instance.setReserveCar(rbean);
	 
	 // 차량 정보를 얻어오는 메서드 
	 Rentcar cbean = RentcarDAO.instance.getOneCar(rbean.getNo());
	 
	 // 차량 총 금액 
	 // 선택한 차량의 수량 , 가격하고 , 몇일 빌릴지 계산 
	 int totalCar = cbean.getPrice() * rbean.getQty() * rbean.getDday();
	 
	 // 옵션 금액 
	 int usein =0,usewifi = 0,useseat =0;
	 if(rbean.getUsein() == 1){
		 usein = 10000;
	 }
	 if(rbean.getUsewifi() == 1){
		 usewifi = 10000;
	 }
	 if(rbean.getUseseat() == 1){
		 useseat = 10000;
	 }
	 
	 // 기본 가격 있는데 
	 // 그 후 에 옵션이 추가되서 계산되는 명령문 
	 int totalOption = (rbean.getQty() * rbean.getDday() * (usein + usewifi + useseat));
	 	 
	 %>
	 <!-- 옵션을 선택하면 만원씩 추가하기  -->
	 
	 <div align="center">
		<table>
			<tr height="100">
				<td align="center"> 
					<font size="6" color="gray"> 차량 예약 완료 화면 </font> 
				</td>
			</tr>
			<tr height="100">
				<td align="center"> 
					<img src="imgCar/<%= cbean.getImg() %>" width="470" />
				</td>
			</tr>	
			<tr height="50">
				<td align="center">
					<font size="5" color="red"> 차량 총예약 금액 <%= totalCar %> 원 </font>
				</td>
			</tr>
			<tr height="50">
				<td align="center">
					<font size="5" color="red"> 차량 총옵션 금액 <%= totalOption %> 원 </font>
				</td>
			</tr>			
			<tr height="50">
				<td align="center">
					<font size="5" color="red"> 차량 총 금액 <%= totalOption + totalCar %> 원 </font>
				</td>
			</tr>	
		</table>
	</div>
</body>
</html>