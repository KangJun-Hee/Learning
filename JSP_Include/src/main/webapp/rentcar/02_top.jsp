<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>02</title>
</head>
<body>
	<!-- 세션 이용한 로그인처리 -->
	<%
		//세션에서 데이터 가지고 온다
		String id = (String)session.getAttribute("id");
		//세션의 데이터가 null->GUEST로 저장하겠다~
		if(id == null){
			id="GUEST";
		} else {
			
		}
	%>
	<table>
		<tr height="70">
			<td colspan="4"><a href="01_carMain.jsp"
				style="text-decoration: none"> <img alt=""
					src="imgCar/rent_logo.jpg" height="120">
			</a></td>
			<td align="center" width="200">
				<!--  로그인 할 때 채워야되는 부분 -->
				<%=id%>님
				
				<%
					if(id.equals("GUEST")){	
				%>
						
						<button type="button" onclick="location.href='05_memberLogin.jsp'">
							Log In
						</button>
						
				<%	} else { %>
						
						<button type="button" onclick="location.href='07_memberLogout.jsp'">
							Log Out
						</button>
						
				<%  } %>	
			</td>
		</tr>
		<tr height="50">
			<td align="center" width="200" bgcolor="pink"><font
				color="white" size="5"><a
					href="01_main.jsp?center=08_carReserveMain.jsp"
					style="text-decoration: none">예 약 하 기</a></font></td>
			<td align="center" width="200" bgcolor="pink"><font
				color="white" size="5"><a
					href="01_main.jsp?center=14_carReserveView.jsp"
					style="text-decoration: none">예 약 확 인</a></font></td>
			<td align="center" width="200" bgcolor="pink"><font
				color="white" size="5"><a href="#"
					style="text-decoration: none">자유게시판</a></font></td>
			<td align="center" width="200" bgcolor="pink"><font
				color="white" size="5"><a href="#"
					style="text-decoration: none">이 벤 트</a></font></td>
			<td align="center" width="200" bgcolor="pink"><font
				color="white" size="5"><a href="#"
					style="text-decoration: none">고 객 센 터</a></font></td>
		</tr>
	</table>

</body>
</html>