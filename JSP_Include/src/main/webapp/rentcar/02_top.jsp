<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<!--  세션을 이용한 로그인처리  -->
	<%
		// 세션영역에서 데이터를 가지고 온다.
		String id = (String)session.getAttribute("id");
		
		// 세션영역에 데이터가 null  -> GUSET 저장한다.
		if(id == null){
			id = "GUEST";			
		}	
	%>

	<table>
		<tr height="70">
			<td colspan="4">
				<a href="01_carMain.jsp" style="text-decoration: none">
				<img alt="" src="_09_imgCar/rent_logo.jpg" height="120">
				</a>
			</td>
			
			<td align="center" width="200">
				<!--  로그인 할 때 채워야되는 부분 -->
				<%= id %> 님
				<%
					if(id.equals("GUEST")){
				%>
				<button onclick ="location.href='05_memberLogin.jsp'">
				로그인 
				</button>
				<%
					}else{				
				%>
				<button onclick ="location.href='07_memberLogout.jsp'">
				로그아웃 
				</button>
				<%
				}
				%>
				
			</td>
		</tr>
		<tr height="50">
			<td align="center" width="200" bgcolor="pink">
				<font color="white" size="5"><a href="01_main.jsp?center=08_carReserveMain.jsp" 
				style="text-decoration: none">예 약 하 기</a></font>
			</td>
			<td align="center" width="200" bgcolor="pink">
				<font color="white" size="5"><a href="01_main.jsp?center=14_carReserveView.jsp" 
				style="text-decoration: none">예 약 확 인</a></font>
			</td>
			<td align="center" width="200" bgcolor="pink">
				<font color="white" size="5"><a href="#" style="text-decoration: none">자유게시판</a></font>
			</td>
			<td align="center" width="200" bgcolor="pink">
				<font color="white" size="5"><a href="#" style="text-decoration: none">이  벤  트</a></font>
			</td>
			<td align="center" width="200" bgcolor="pink">
				<font color="white" size="5"><a href="#" style="text-decoration: none">고 객 센 터</a></font>
			</td>
		</tr>
	</table>

</body>
</html>