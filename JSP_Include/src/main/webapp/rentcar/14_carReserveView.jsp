<%@page import="com.rentcar.RentcarDAO"%>
<%@page import="com.rentcar.CarView"%>
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
	//로그인돼있는지 아이디 읽어옴
	String id = (String) session.getAttribute("id");

	if (id == null) {
	%>

	<script type="text/javascript">
		alert("로그인을 먼저 해주세요~");
		location.href = "01_main.jsp?center=05_memberLogin.jsp";
	</script>
	<%
	}
	//로그인하는 사람들이 다르면 각각 예약한 자료만 보여 준다.
	ArrayList<CarView> list = RentcarDAO.instance.getAllReserve(id);
	%>
	<div align="center">
		<table>
			<tr height="100">
				<td align="center" colspan="11"><font size="6" color="gray">
						차량 예약 완료 화면 </font></td>
			</tr>
		</table>
		<table border="1">
			<tr height="40">
				<td width="150" align="center">이미지</td>
				<td width="150" align="center">이름</td>
				<td width="150" align="center">대여일</td>
				<td width="60" align="center">대여기간</td>
				<td width="100" align="center">금액</td>
				<td width="60" align="center">수량</td>
				<td width="60" align="center">보험</td>
				<td width="60" align="center">wifi</td>
				<td width="60" align="center">베이비시트</td>
				<td width="60" align="center">네비게이션</td>
				<td width="90" align="center">삭제</td>
			</tr>
			<%
			for (CarView temp : list) {
			%>
			<tr height="70">
				<td height="70" align="center"><img
					src="imgCar/<%=temp.getImg()%>" width="120" height="70"></td>
				<td width="100" align="center"><%=temp.getName()%></td>
				<td width="150" align="center"><%=temp.getRday()%></td>
				<td width="150" align="center"><%=temp.getDday()%></td>
				<td width="100" align="center"><%=temp.getPrice()%> 원</td>
				<td width="60" align="center"><%=temp.getQty()%></td>
				<td width="100" align="center"><%=temp.getUsein()%></td>
				<td width="60" align="center"><%=temp.getUsewifi()%></td>
				<td width="60" align="center"><%=temp.getUseseat()%></td>
				<td width="60" align="center"><%=temp.getUsenavi()%></td>
				<td width="90" align="center">
					<button
						onclick="location.href='15_carReserveDel.jsp?id=<%=id%>&rday=<%=temp.getRday()%>'">삭제</button>
				</td>
			</tr>
			<%
			}
			%>
		</table>

	</div>
</body>
</html>